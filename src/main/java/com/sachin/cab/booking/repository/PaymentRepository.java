package com.sachin.cab.booking.repository;

import com.sachin.cab.booking.model.Payment;

import java.util.List;

public interface PaymentRepository {
    void save(Payment payment);
    List<Payment> findAll();
    Payment findByTransactionRef(String transactionRef);
}
