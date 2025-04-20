package com.sachin.cab.booking.controller;

import com.sachin.cab.booking.model.User;
import com.sachin.cab.booking.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(int id, String name, String address, String phoneNumber) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        userService.registerUser(user);
        System.out.println("User created successfully!");
    }

    public void listUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void getUser(int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            System.out.println("User Found: " + user);
        } else {
            System.out.println("User not found!");
        }
    }

    public void deleteUser(int id) {
        userService.removeUser(id);
        System.out.println("User deleted successfully.");
    }
}
