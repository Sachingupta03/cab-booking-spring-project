package com.sachin.cab.booking.service.impl;

import com.sachin.cab.booking.model.Ride;
import com.sachin.cab.booking.repository.RideRepository;
import com.sachin.cab.booking.service.RideService;

import java.util.List;

public class RideServiceImpl implements RideService {
    private final RideRepository rideRepository;

    public RideServiceImpl(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public void bookRide(Ride ride) {
        rideRepository.save(ride);
    }

    @Override
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    @Override
    public Ride getRideByDriverId(String driverId) {
        return rideRepository.findByDriverId(driverId);
    }

}
