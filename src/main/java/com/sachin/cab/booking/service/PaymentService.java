package com.sachin.cab.booking.service;

import com.sachin.cab.booking.model.Payment;

import java.util.List;

public interface PaymentService {
    void processPayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentByRef(String transactionRef);
}
