package dev.jaffer.paymentservice.services;

import com.stripe.exception.StripeException;
import dev.jaffer.paymentservice.paymentgateways.PaymentGateWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    private PaymentGateWay paymentGateWay;

    public PaymentService(PaymentGateWay paymentGateWay) {
        this.paymentGateWay = paymentGateWay;
    }
    public String createPaymentLink(String orderId) throws StripeException {

        return paymentGateWay.createPaymentLink(10000L, orderId);
    }
}
