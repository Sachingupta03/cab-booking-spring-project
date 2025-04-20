package com.sachin.cab.booking.repository;

import com.sachin.cab.booking.model.Driver;

import java.util.List;

public interface DriverRepository {
    void save(Driver driver);
    Driver findById(int id);
    List<Driver> findAll();
    void delete(int id);
}
