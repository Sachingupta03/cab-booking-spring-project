package com.sachin.cab.booking.repository.impl;

import com.sachin.cab.booking.model.Payment;
import com.sachin.cab.booking.repository.PaymentRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {

    private final DataSource dataSource;

    public PaymentRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Payment payment) {
        String query = "INSERT INTO payments (transaction_reference, amount, status, description, user_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, payment.getTransactionReference());
            statement.setDouble(2, payment.getAmount());
            statement.setString(3, payment.getStatus());
            statement.setString(4, payment.getDescription());
            statement.setInt(5, payment.getUserId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Payment saved successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error saving payment: " + e.getMessage());
        }
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payments";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setTransactionReference(resultSet.getString("transaction_reference"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setStatus(resultSet.getString("status"));
                payment.setDescription(resultSet.getString("description"));
                payment.setUserId(resultSet.getInt("user_id"));
                payments.add(payment);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving payments: " + e.getMessage());
        }

        return payments;
    }

    @Override
    public Payment findByTransactionRef(String transactionRef) {
        String query = "SELECT * FROM payments WHERE transaction_reference = ?";
        Payment payment = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, transactionRef);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                payment = new Payment();
                payment.setTransactionReference(resultSet.getString("transaction_reference"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setStatus(resultSet.getString("status"));
                payment.setDescription(resultSet.getString("description"));
                payment.setUserId(resultSet.getInt("user_id"));
            }

        } catch (SQLException e) {
            System.out.println("Error finding payment by transaction reference: " + e.getMessage());
        }

        return payment;
    }
}
