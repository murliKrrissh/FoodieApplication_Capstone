package com.example.CustomerService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED,reason = "Customer Not Found")
public class CustomerNotFound extends Exception {
}
