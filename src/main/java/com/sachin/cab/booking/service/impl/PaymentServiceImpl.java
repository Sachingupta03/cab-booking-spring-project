package com.sachin.cab.booking.service.impl;

import com.sachin.cab.booking.model.Payment;
import com.sachin.cab.booking.repository.PaymentRepository;
import com.sachin.cab.booking.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

        private PaymentRepository paymentRepository;

        public PaymentServiceImpl(PaymentRepository paymentRepository) {
            this.paymentRepository = paymentRepository;
        }

        @Override
        public void processPayment(Payment payment) {
            paymentRepository.save(payment);
        }

        @Override
        public List<Payment> getAllPayments() {
            return paymentRepository.findAll();
        }

        @Override
        public Payment getPaymentByRef(String transactionRef) {
            return paymentRepository.findByTransactionRef(transactionRef);
        }
}
