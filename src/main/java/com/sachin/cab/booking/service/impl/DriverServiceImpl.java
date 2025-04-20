package com.sachin.cab.booking.service.impl;

import com.sachin.cab.booking.repository.DriverRepository;
import com.sachin.cab.booking.service.DriverService;
import com.sachin.cab.booking.model.Driver;

import java.util.List;

    public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void registerDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

        @Override
        public void removeDriver(int id) {

        }

        @Override
        public void save(Driver driver) {

        }

        @Override
        public List<Driver> findAll() {
            return List.of ();
        }

        @Override
        public Driver findById(int id) {
            return null;
        }

        @Override
        public void delete(int id) {

        }

        @Override
    public Driver getDriverById(int driverId) {
        return driverRepository.findById(driverId);
    }

    @Override
    public void deleteDriver(int driverId) {
        driverRepository.delete(driverId);
    }
}
