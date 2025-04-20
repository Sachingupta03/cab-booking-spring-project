package com.sachin.cab.booking.service.impl;

import com.sachin.cab.booking.model.User;
import com.sachin.cab.booking.repository.UserRepository;
import com.sachin.cab.booking.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void removeUser(int id) {
        userRepository.delete(id);
    }
}
