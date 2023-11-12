package com.example.CustomerService.controller;

import com.example.CustomerService.domain.Customer;
import com.example.CustomerService.domain.Order;
import com.example.CustomerService.exception.CustomerAlreadyExistsException;
import com.example.CustomerService.exception.CustomerNotFound;
import com.example.CustomerService.repository.CustomerRepository;
import com.example.CustomerService.service.CustomerService;
import com.example.RestaurantService.domain.Cuisine;
import com.example.RestaurantService.domain.Restaurant;
import com.example.RestaurantService.exception.RestaurantNotFoundExp;
import io.jsonwebtoken.Claims;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/user")
public class CustomerController {

    private CustomerService customerService;
    private ResponseEntity<?> responseEntity;
    private CustomerRepository customerRepository;


    @Autowired
    public CustomerController(CustomerService customerService,CustomerRepository customerRepository){
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
        return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
    }

    @GetMapping("/AllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @PostMapping("/addOrderToOrderList/{email}")
    public ResponseEntity<?> addOrderInOrderList(@RequestBody Order orders,@PathVariable String email){
        Customer customer = customerRepository.findById(email).get();
        customer.getOrderDetails().add(orders);
        Customer saveCustomer = customerRepository.save(customer);
        return responseEntity.ok(saveCustomer);
    }

    @DeleteMapping("/removeOrderById/{email}/{orderId}")
    public ResponseEntity<?> removeFavouritesFromList(@PathVariable String email,@PathVariable int orderId){
        return new ResponseEntity<>(customerService.removeOrderFromOrderDetails(email,orderId),HttpStatus.OK);
    }

    @GetMapping("/getOrderByEmail/{email}")
    public ResponseEntity getOrderByEmail(@PathVariable String email){
        return new ResponseEntity(customerService.getOrderById(email),HttpStatus.OK);
    }


}
