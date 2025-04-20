package com.sachin.cab.booking.service;

import com.sachin.cab.booking.model.Driver;

import java.util.List;

public interface DriverService {
    void registerDriver(Driver driver);
    Driver getDriverById(int id);
    List<Driver> getAllDrivers();
    void removeDriver(int id);

    void save(Driver driver);

    List<Driver> findAll();

    Driver findById(int id);

    void delete(int id);

    void deleteDriver(int driverId);
}
