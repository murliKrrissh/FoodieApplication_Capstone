package com.example.CustomerService.service;

import com.example.CustomerService.domain.Customer;
import com.example.CustomerService.domain.Order;
import com.example.CustomerService.exception.CustomerAlreadyExistsException;
import com.example.CustomerService.exception.CustomerNotFound;
import org.apache.catalina.LifecycleState;

import java.util.List;


public interface CustomerService {
   public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;
    public List<Customer> getAllCustomer();
    public List<Order> getOrderById(String email);
    public Customer getCustomerByName(String name);
    public Customer addOrderInOrderDetails(String email,Order order);
    public boolean removeOrderFromOrderDetails(String email,int orderId);
}
