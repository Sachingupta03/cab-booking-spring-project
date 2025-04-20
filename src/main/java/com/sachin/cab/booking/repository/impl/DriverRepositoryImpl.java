package com.sachin.cab.booking.repository.impl;

import com.sachin.cab.booking.model.Driver;
import com.sachin.cab.booking.repository.DriverRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository {

    private final DataSource dataSource;

    public DriverRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Driver driver) {
        String sql = "INSERT INTO drivers (driver_id, name, phone, license_number, rating) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, driver.getDriverId());
            stmt.setString(2, driver.getName());
            stmt.setString(3, driver.getPhoneNumber());
            stmt.setString(4, driver.getLicenseNumber());
            stmt.setDouble(5, driver.getRating());

            stmt.executeUpdate();
            System.out.println("Driver saved successfully: " + driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Driver findById(int id) {
        String sql = "SELECT * FROM drivers WHERE driver_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapToDriver(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM drivers WHERE driver_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Driver with ID " + id + " deleted.");
            } else {
                System.out.println("Driver with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to map ResultSet to Driver object
    private Driver mapToDriver(ResultSet rs) throws SQLException {
        Driver driver = new Driver();
        driver.setDriverId(rs.getInt("driver_id"));
        driver.setName(rs.getString("name"));
        driver.setPhoneNumber(rs.getString("phone"));
        driver.setLicenseNumber(rs.getString("license_number"));
        driver.setRating(rs.getDouble("rating"));
        return driver;
    }

    // Optional: If you need to implement findAll(), use a similar approach
    @Override
    public List<Driver> findAll() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                drivers.add(mapToDriver(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }
}
