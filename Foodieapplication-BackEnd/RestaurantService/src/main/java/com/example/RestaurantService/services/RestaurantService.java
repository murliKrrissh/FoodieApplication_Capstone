package com.example.RestaurantService.services;

import com.example.RestaurantService.domain.Cuisine;
import com.example.RestaurantService.domain.Restaurant;
import com.example.RestaurantService.exception.*;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistExp;
    public List<Restaurant> getAllRestaurants();
    public List<Cuisine> getCuisinesByRestaurantId(int restaurantId);

    public Cuisine getCuisineBYRestaurantIdAndCuisineId(int restaurantId,int cuisineId);
    public List<Restaurant> getRestaurantByLocation(String restaurantLocation) throws RestaurantLocationNotFound;
    public Restaurant getRestaurantByName(String restaurantName) throws RestaurantNotFoundExp;
    public List<Restaurant> getRestaurantByCuisineType(String cuisineType) throws CuisineTypeNotFound;
    public Restaurant updateRestaurant(Restaurant restaurant,int restaurantId) throws RestaurantNotFoundExp;
    public boolean deleteRestaurantById(int restaurantId) throws  RestaurantNotFoundExp;
    public boolean deleteCuisineByRestaurantId(int restaurantId,Cuisine cuisine) throws RestaurantNotFoundExp, CuisineNotFound;
}
