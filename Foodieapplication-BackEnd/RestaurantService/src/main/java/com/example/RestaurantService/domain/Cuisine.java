package com.example.RestaurantService.domain;

import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cuisine {
    @Id
    private  int cuisineId;
    private String cuisineType;
    private String itemName;
    private double itemPrice;
    private String cuisineRating;
    private String cuisineDescription;

    public Cuisine() {
    }

    public Cuisine(int cuisineId, String cuisineType, String itemName, double itemPrice, String cuisineRating, String cuisineDescription) {
        this.cuisineId = cuisineId;
        this.cuisineType = cuisineType;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.cuisineRating = cuisineRating;
        this.cuisineDescription = cuisineDescription;
    }

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getCuisineRating() {
        return cuisineRating;
    }

    public void setCuisineRating(String cuisineRating) {
        this.cuisineRating = cuisineRating;
    }

    public String getCuisineDescription() {
        return cuisineDescription;
    }

    public void setCuisineDescription(String cuisineDescription) {
        this.cuisineDescription = cuisineDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Cuisine{" +
                "cuisineId=" + cuisineId +
                ", cuisineType='" + cuisineType + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", cuisineRating='" + cuisineRating + '\'' +
                ", cuisineDescription='" + cuisineDescription + '\'' +
                '}';
    }
}
