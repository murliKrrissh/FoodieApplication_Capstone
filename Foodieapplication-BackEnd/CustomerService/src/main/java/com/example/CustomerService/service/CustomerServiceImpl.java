package com.example.CustomerService.service;

import com.example.CustomerService.domain.Customer;
import com.example.CustomerService.domain.CustomerDto;
import com.example.CustomerService.domain.Order;
import com.example.CustomerService.exception.CustomerAlreadyExistsException;
import com.example.CustomerService.exception.CustomerNotFound;
import com.example.CustomerService.proxy.CustomerProxy;
import com.example.CustomerService.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService{
    private CustomerRepository customerRepository;
    private CustomerProxy customerProxy;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,CustomerProxy customerProxy){
        this.customerRepository = customerRepository;
        this.customerProxy = customerProxy;
    }

    @Override
    public Customer addCustomer(Customer customer){
        CustomerDto customerDto = new CustomerDto();

        customerDto.setEmail(customer.getEmail());
        customerDto.setPassword(customer.getPassword());
        customerDto.setName(customer.getName());
        customerDto.setRole(customer.getRole());
        customerDto.setAddress(customer.getAddress());
        customerDto.setPhoneNo(customer.getPhoneNo());
        System.out.println(customerDto);
        customerProxy.saveUser(customerDto);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Order> getOrderById(String email) {
        Customer customer = customerRepository.findById(email).get();
        return customer.getOrderDetails();
    }

    @Override
    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer addOrderInOrderDetails(String email, Order order) {
        Customer customer = customerRepository.findById(email).get();
            customer.setOrderDetails(new ArrayList<>());
            customer.getOrderDetails().add(order);
            customerRepository.save(customer);
            return customer;
    }

    @Override
    public boolean removeOrderFromOrderDetails(String email, int orderId) {
        Customer customer = customerRepository.findById(email).get();
        List<Order> order = customer.getOrderDetails();
                order.remove(orderId);
                customerRepository.save(customer);
        return true;
    }
}
