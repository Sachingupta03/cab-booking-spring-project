package com.sachin.cab.booking.repository;

import com.sachin.cab.booking.model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> findAll();
    User findById(int id);
    void delete(int id);

}
