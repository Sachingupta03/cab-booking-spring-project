package com.sachin.cab.booking.controller;

import com.sachin.cab.booking.model.Driver;
import com.sachin.cab.booking.service.DriverService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    public void createDriver(int id, String name, String phone, String license, int experience) {
        Driver driver = new Driver();
        driver.setDriverId(id);
        driver.setDriverName(name);
        driver.setPhoneNumber(phone);
        driver.setLicenseNumber(license);
        driver.setDateOfBirth(LocalDate.of(1990, 1, 1));
        driver.setLicenseExpiryDate(LocalDate.of(2030, 1, 1));
        driver.setVehicleType("Car");
        driver.setActive(true);
        driver.setYearsOfExperience(experience);
        driverService.registerDriver(driver);
        System.out.println("Driver created successfully!");
    }

    public void listDrivers() {
        List<Driver> list = driverService.getAllDrivers();
        list.forEach(System.out::println);
    }

    public void getDriver(int id) {
        Driver driver = driverService.getDriverById(id);
        System.out.println(driver != null ? driver : "Driver not found!");
    }

    public void deleteDriver(int id) {
        driverService.removeDriver(id);
        System.out.println("Driver deleted.");
    }

}
