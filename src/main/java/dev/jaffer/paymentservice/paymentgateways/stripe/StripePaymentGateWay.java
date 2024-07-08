package dev.jaffer.paymentservice.paymentgateways.stripe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import dev.jaffer.paymentservice.paymentgateways.PaymentGateWay;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateWay implements PaymentGateWay {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey ;

    @Override
    public String createPaymentLink(Long amount,String orderId) throws StripeException {

        Stripe.apiKey = stripeSecretKey;
        //create dummy product object for stripe
        ProductCreateParams productCreateParams =
                ProductCreateParams.builder()
                        .setName("Generic Product1")
                        .build();
        //create product in stripe
        Product product = Product.create(productCreateParams);

        //code to create payment link using stripe
        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount) //amount * 100
                        .setProduct(product.getId())
                        .build();
        Price price = Price.create(params);


        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://google.com/?order_id="+orderId)
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);
        return paymentLink.getUrl();
    }
}
