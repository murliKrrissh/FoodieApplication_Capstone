package com.example.RestaurantService.controller;

import com.example.RestaurantService.domain.Cuisine;
import com.example.RestaurantService.domain.Restaurant;
import com.example.RestaurantService.exception.*;
import com.example.RestaurantService.repository.RestaurantRepository;
import com.example.RestaurantService.services.RestaurantService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {
    public RestaurantService restaurantService;
    public RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantService restaurantService,RestaurantRepository restaurantRepository) {
        this.restaurantService = restaurantService;
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/saveRestaurant")
    public ResponseEntity saveRestaurant(HttpServletRequest request,@RequestBody Restaurant restaurant) throws RestaurantAlreadyExistExp {
        if (request.getAttribute("attribute2").equals("Vendor")) {
            return new ResponseEntity<>(restaurantService.saveRestaurant(restaurant), HttpStatus.OK);
        }
        else{
            return new ResponseEntity("You cant Access the Add Restaurant Service",HttpStatus.LOCKED);
        }
    }

    @PostMapping("/addCuisine/{restaurantId}")
    public ResponseEntity<?> addFoodItemsToSameRestaurant(HttpServletRequest request, @PathVariable int restaurantId, @RequestBody Cuisine cuisines) throws RestaurantNotFoundExp {
        String requiredEmail = (String)request.getAttribute("attribute1");
        Restaurant restaurant1 = restaurantRepository.findById(restaurantId).get();
        String email1 = restaurant1.getEmail();
       if(requiredEmail.equals(email1)) {
           Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
           restaurant.getCuisines().add(cuisines);
           Restaurant savedRestaurant = restaurantRepository.save(restaurant);
           return ResponseEntity.ok(savedRestaurant);
       }
       else{
           return new ResponseEntity("You cant Add Cuisine",HttpStatus.LOCKED);
       }
    }

    @GetMapping("/AllRestaurant")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/AllCuisinesById/{restaurantId}")
    public List<Cuisine> getAllCuisinesById(@PathVariable int restaurantId){
        return restaurantService.getCuisinesByRestaurantId(restaurantId);
    }

    @GetMapping("/getCuisinesByRestaurantIdAndCuisineId/{restaurantId}/{cuisineId}")
    public Cuisine getCuisinesByRestaurantIdAndCuisineId(@PathVariable int restaurantId,@PathVariable int cuisineId){
        return restaurantService.getCuisineBYRestaurantIdAndCuisineId(restaurantId,cuisineId);
    }



    @GetMapping("/getRestaurantByLocation/{restaurantLocation}")
    public ResponseEntity getRestaurantByLocation(@PathVariable String restaurantLocation) throws RestaurantLocationNotFound {
        try {
            return new ResponseEntity(restaurantService.getRestaurantByLocation(restaurantLocation), HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity(exp.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getRestaurantByName/{restaurantName}")
    public ResponseEntity getRestaurantByName(@PathVariable String restaurantName) throws RestaurantNotFoundExp {
        try {
            return new ResponseEntity(restaurantService.getRestaurantByName(restaurantName), HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity(exp.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getRestaurantByCuisineType/{cuisineType}")
    public ResponseEntity getRestaurantByCuisineType(@PathVariable String cuisineType) throws RestaurantNotFoundExp {
        try {
            return new ResponseEntity(restaurantService.getRestaurantByCuisineType(cuisineType), HttpStatus.OK);
        } catch (Exception exp) {
            return new ResponseEntity(exp.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity updateRestaurantById(@PathVariable int restaurantId,@RequestBody Restaurant restaurant) throws RestaurantNotFoundExp{
        return new ResponseEntity<>(restaurantService.updateRestaurant(restaurant,restaurantId),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteRestaurant/{restaurantId}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable int restaurantId) throws RestaurantNotFoundExp {
        return new ResponseEntity<>(restaurantService.deleteRestaurantById(restaurantId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCuisine/{restaurantId}")
    public ResponseEntity<?> deleteFoodItem(@PathVariable int restaurantId,@RequestBody Cuisine cuisine) throws RestaurantNotFoundExp, CuisineNotFound {
        return new ResponseEntity<>(restaurantService.deleteCuisineByRestaurantId(restaurantId,cuisine),HttpStatus.OK);
    }
}
