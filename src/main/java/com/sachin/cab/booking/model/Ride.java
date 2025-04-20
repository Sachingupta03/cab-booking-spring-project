package com.sachin.cab.booking.model;

import java.time.LocalDateTime;

public class Ride {
    private String rideId;
    private String driverId;
    private String passengerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String pickupLocation;
    private String dropoffLocation;
    private double distance;
    private double fare;
    private double driverRating;
    private double passengerRating;

    // Getters
    public String getRideId() {
        return rideId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public double getDriverRating() {
        return driverRating;
    }

    public double getPassengerRating() {
        return passengerRating;
    }

    // Setters
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setDriverRating(double driverRating) {
        this.driverRating = driverRating;
    }

    public void setPassengerRating(double passengerRating) {
        this.passengerRating = passengerRating;
    }
}
