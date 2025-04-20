package com.sachin.cab.booking.controller;

import com.sachin.cab.booking.model.Ride;
import com.sachin.cab.booking.service.RideService;

import java.util.List;

public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService)
    {
        this.rideService = rideService;
    }

    public void createRide(Ride ride) {
        rideService.bookRide(ride);
    }

    public void showAllRides() {
        List<Ride> rides = rideService.getAllRides();
        for (Ride r : rides) {
            System.out.println("Ride from " + r.getPickupLocation() + " to " + r.getDropoffLocation() + " | Fare: ₹" + r.getFare());
        }
    }

    public void showRideByDriver(String driverId) {
        Ride ride = rideService.getRideByDriverId(driverId);
        if (ride != null) {
            System.out.println("Driver Ride: " + ride.getPickupLocation() + " -> " + ride.getDropoffLocation());
        } else {
            System.out.println("No ride found for driver ID: " + driverId);
        }
    }

}
