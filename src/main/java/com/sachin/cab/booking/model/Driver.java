package com.sachin.cab.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data

public class Driver {
    private int driverId;
    private String DriverName;
    private  String PhoneNumber;
    private LocalDate dateOfBirth;
    private String licenseNumber;
    private LocalDate licenseExpiryDate;
    private String vehicleType; // e.g., "Car", "Truck", "Motorcycle"
    private boolean isActive;
    private int yearsOfExperience;

    public int getDriverId() {
        return 0;
    }

    public void setDriverId(int id) {
    }

    public void setPhoneNumber(String phone) {
    }

    public void setDriverName(String name) {
    }

    public void setLicenseNumber(String license) {
    }

    public void setDateOfBirth(LocalDate of) {
    }

    public void setLicenseExpiryDate(LocalDate of) {
    }

    public void setVehicleType(String car) {
    }

    public void setActive(boolean b) {
    }

    public void setYearsOfExperience(int experience) {
    }

    public String getName() {
        return null;
    }

    public String getPhoneNumber() {
        return null;
    }

    public String getLicenseNumber() {
     return null;}

    public double getRating() {
        return 0;
    }

    public void setName(String name) {
    }

    public void setRating(double rating) {
    }
}
