package com.example.CustomerService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Customer {
    @Id
    private String email;
    private String password;
    private String name;
    private String role = "user";
    private String address;
    private long phoneNo;
    private List<Order> orderDetails;

    public Customer() {
        this.orderDetails = new ArrayList<>();
    }

    public Customer(String email, String password, String name, String role, String address, long phoneNo, List<Order> orderDetails) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.address = address;
        this.phoneNo = phoneNo;
        this.orderDetails = orderDetails;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Order> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Order> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo=" + phoneNo +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
