package dev.jaffer.paymentservice.controllers;

import dev.jaffer.paymentservice.dtos.CreatePaymentLinkRequestDto;
import dev.jaffer.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/createPaymentLink")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto createPaymentLinkRequestDto){
        return paymentService.createPaymentLink(createPaymentLinkRequestDto.getOrderId());
    }
}
