package com.example.RestaurantService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Cuisine Not Found")
public class CuisineNotFound extends Exception {
}

