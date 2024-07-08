package dev.jaffer.paymentservice.paymentgateways.stripe;

import dev.jaffer.paymentservice.paymentgateways.PaymentGateWay;

public class StripePaymentGateWay implements PaymentGateWay {
    @Override
    public String createPaymentLink(String email, Long amount, String phoneNumber) {
        return "";

        //code to create payment link using stripe
    }
}
