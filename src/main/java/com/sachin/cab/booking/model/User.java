package com.sachin.cab.booking.model;

import lombok.Data;


@Data
public class User {
    private int id;
    private String Name;
    private String Address;
    private String PhoneNumber;

    public int getId() {
    return 0;
    }

    public void setId(int id) {
    }

    public void setName(String name) {
    }

    public void setAddress(String address) {
    }

    public void setPhoneNumber(String phoneNumber) {
    }

    public String getName() {
        return null;
    }

    public String getAddress() {
    return null;}

    public String getPhoneNumber() {
        return null;
    }
}
