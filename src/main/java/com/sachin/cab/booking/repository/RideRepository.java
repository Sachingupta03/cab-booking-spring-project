package com.sachin.cab.booking.repository;

import com.sachin.cab.booking.model.Ride;

import java.util.List;

public interface RideRepository {
    void save(Ride ride);
    List<Ride> findAll();
    Ride findByDriverId(String driverId);
}
