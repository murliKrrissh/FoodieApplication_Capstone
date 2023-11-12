package com.example.CustomerService.repository;

import com.example.CustomerService.domain.Customer;
import com.example.RestaurantService.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

    public Customer findByName(String name);
}
