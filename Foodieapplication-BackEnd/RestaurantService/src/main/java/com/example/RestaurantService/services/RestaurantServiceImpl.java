package com.example.RestaurantService.services;

import com.example.RestaurantService.domain.Cuisine;
import com.example.RestaurantService.domain.Restaurant;
import com.example.RestaurantService.exception.*;
import com.example.RestaurantService.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    public RestaurantRepository restaurantRepository;
    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistExp {
        if (restaurantRepository.findById(restaurant.getRestaurantId()).isPresent()){
                throw new RestaurantAlreadyExistExp();
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Cuisine> getCuisinesByRestaurantId(int restaurantId) {
        Optional<Restaurant> restaurantData = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = restaurantData.get();
        return restaurant.getCuisines();
    }

    @Override
    public Cuisine getCuisineBYRestaurantIdAndCuisineId(int restaurantId, int cuisineId) {
        Optional<Restaurant> restaurantData = restaurantRepository.findById(restaurantId);
        int count = cuisineId-1;
        Restaurant restaurant = restaurantData.get();
        Cuisine cuisines = restaurant.getCuisines().get(count);
        return cuisines;
    }

    @Override
    public List<Restaurant> getRestaurantByLocation(String restaurantLocation) throws RestaurantLocationNotFound {
        return restaurantRepository.findByRestaurantLocation(restaurantLocation);
    }
    @Override
    public Restaurant getRestaurantByName(String restaurantName) throws RestaurantNotFoundExp {
        return restaurantRepository.findByRestaurantName(restaurantName);
    }

    @Override
    public List<Restaurant> getRestaurantByCuisineType(String cuisineType) throws CuisineTypeNotFound {
        return restaurantRepository.findRestaurantByCuisineType(cuisineType);
    }

    @Override
    public boolean deleteRestaurantById(int restaurantId) throws RestaurantNotFoundExp {
        if(restaurantRepository.findById(restaurantId).isEmpty()){
            throw new RestaurantNotFoundExp();
        }
        else {
            restaurantRepository.deleteById(restaurantId);
            return true;
        }
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant, int restaurantId) throws RestaurantNotFoundExp {
        Optional<Restaurant> restaurantData = restaurantRepository.findById(restaurantId);
        if(restaurantData.isEmpty()){
            throw new RestaurantNotFoundExp();
        }
        Restaurant currentData = restaurantData.get();
        currentData.setRestaurantName(restaurant.getRestaurantName());
        currentData.setRestaurantLocation(restaurant.getRestaurantLocation());
        return restaurantRepository.save(currentData);
    }

    @Override
    public boolean deleteCuisineByRestaurantId(int restaurantId, Cuisine cuisine) throws RestaurantNotFoundExp, CuisineNotFound {
        Optional<Restaurant> restaurantData = restaurantRepository.findById(restaurantId);
        if (restaurantData.isPresent()) {
            Restaurant restaurant = restaurantData.get();
            Optional<Cuisine> cuisines = restaurant.getCuisines().stream()
                    .filter(cuisines1 -> cuisines1.getCuisineId() == cuisine.getCuisineId())
                    .findFirst();
            if (cuisines.isPresent()) {
                Cuisine cuisine1 = cuisines.get();
                restaurant.getCuisines().remove(cuisine1);
                restaurantRepository.save(restaurant);
                return true;
            } else {
                throw new RestaurantNotFoundExp();
            }
        } else {
            throw new CuisineNotFound();
        }
    }
}

