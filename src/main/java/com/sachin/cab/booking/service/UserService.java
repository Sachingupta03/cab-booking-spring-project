package com.sachin.cab.booking.service;

import com.sachin.cab.booking.model.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
    void removeUser(int id);
}
