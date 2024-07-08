package dev.jaffer.paymentservice.paymentgateways;

public interface PaymentGateWay {

    String createPaymentLink(String email,
                             Long amount,
                             String phoneNumber);
}
