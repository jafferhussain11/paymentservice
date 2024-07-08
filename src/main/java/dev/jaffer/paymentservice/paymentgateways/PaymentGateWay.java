package dev.jaffer.paymentservice.paymentgateways;

import com.stripe.exception.StripeException;

public interface PaymentGateWay {

    String createPaymentLink(Long amount,String orderId) throws StripeException;
}
