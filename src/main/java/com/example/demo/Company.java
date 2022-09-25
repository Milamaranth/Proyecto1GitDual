package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Company {
    public Address address;

    public Company(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
