package com.sachin.cab.booking.controller;

import com.sachin.cab.booking.model.Payment;
import com.sachin.cab.booking.service.PaymentService;

import java.util.List;

public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment(String rideId, String userId, double amount, String ref, String currency, String desc, String status) {
        Payment payment = new Payment(
        );
        paymentService.processPayment(payment);
    }

    public void listAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        for (Payment p : payments) {
            System.out.println(p);
        }
    }

    public void findPayment(String ref) {
        Payment p = paymentService.getPaymentByRef(ref);
        if (p != null) {
            System.out.println("Found: " + p);
        } else {
            System.out.println("Payment not found.");
        }
    }

}
