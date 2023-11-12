package com.example.RestaurantService.repository;

import com.example.RestaurantService.domain.Cuisine;
import com.example.RestaurantService.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,Integer> {
    public List<Restaurant> findByRestaurantLocation(String restaurantLocation);
    public Restaurant findByRestaurantName(String restaurantName);
    @Query("{'cuisines.cuisineType':{$in:[?0]}}")
    public List<Restaurant> findRestaurantByCuisineType(String cuisineType);

}
