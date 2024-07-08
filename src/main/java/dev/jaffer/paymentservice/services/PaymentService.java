package dev.jaffer.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {



    public String createPaymentLink(String orderId) {
        return "Payment link created";
    }
}
