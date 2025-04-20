package com.sachin.cab.booking.service;

import com.sachin.cab.booking.model.Ride;

import java.util.List;

public interface RideService {
    void bookRide(Ride ride);
    List<Ride> getAllRides();
    Ride getRideByDriverId(String driverId);
}
