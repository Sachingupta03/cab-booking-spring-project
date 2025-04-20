package com.sachin.cab.booking.repository.impl;

import com.sachin.cab.booking.model.Ride;
import com.sachin.cab.booking.repository.RideRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RideRepositoryImpl implements RideRepository {

    private final DataSource dataSource;

    public RideRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Ride ride) {
        String sql = "INSERT INTO rides (ride_id, driver_id, passenger_id, start_time, end_time, pickup_location, dropoff_location, distance, fare, driver_rating, passenger_rating) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ride.getRideId());
            stmt.setString(2, ride.getDriverId());
            stmt.setString(3, ride.getPassengerId());
            stmt.setTimestamp(4, Timestamp.valueOf(ride.getStartTime()));
            stmt.setTimestamp(5, Timestamp.valueOf(ride.getEndTime()));
            stmt.setString(6, ride.getPickupLocation());
            stmt.setString(7, ride.getDropoffLocation());
            stmt.setDouble(8, ride.getDistance());
            stmt.setDouble(9, ride.getFare());
            stmt.setDouble(10, ride.getDriverRating());
            stmt.setDouble(11, ride.getPassengerRating());

            stmt.executeUpdate();
            System.out.println(" Ride saved successfully to DB.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ride> findAll() {
        List<Ride> rides = new ArrayList<>();
        String sql = "SELECT * FROM rides";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ride ride = mapRowToRide(rs);
                rides.add(ride);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rides;
    }

    @Override
    public Ride findByDriverId(String driverId) {
        Ride ride = null;
        String sql = "SELECT * FROM rides WHERE driver_id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, driverId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ride = mapRowToRide(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ride;
    }

    private Ride mapRowToRide(ResultSet rs) throws SQLException {
        Ride ride = new Ride();
        ride.setRideId(rs.getString("ride_id"));
        ride.setDriverId(rs.getString("driver_id"));
        ride.setPassengerId(rs.getString("passenger_id"));
        ride.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
        ride.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
        ride.setPickupLocation(rs.getString("pickup_location"));
        ride.setDropoffLocation(rs.getString("dropoff_location"));
        ride.setDistance(rs.getDouble("distance"));
        ride.setFare(rs.getDouble("fare"));
        ride.setDriverRating(rs.getDouble("driver_rating"));
        ride.setPassengerRating(rs.getDouble("passenger_rating"));
        return ride;
    }
}
