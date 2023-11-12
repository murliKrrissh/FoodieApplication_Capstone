package com.example.RestaurantService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
public class Restaurant {
    @Id
    private int restaurantId;
    private String restaurantName;
    private String email;
    private String restaurantLocation;
    private List<Cuisine> cuisines;

    public Restaurant() {
        this.cuisines = new ArrayList<>();
    }

    public Restaurant(int restaurantId, String restaurantName, String email, String restaurantLocation, List<Cuisine> cuisines) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.email = email;
        this.restaurantLocation = restaurantLocation;
        this.cuisines = cuisines;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", email='" + email + '\'' +
                ", restaurantLocation='" + restaurantLocation + '\'' +
                ", cuisines=" + cuisines +
                '}';
    }
}
