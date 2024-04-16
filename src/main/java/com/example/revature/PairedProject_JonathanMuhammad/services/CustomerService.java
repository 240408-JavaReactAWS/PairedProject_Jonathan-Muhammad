package com.example.revature.PairedProject_JonathanMuhammad.services;


import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import com.example.revature.PairedProject_JonathanMuhammad.repos.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerDAO cd;

    @Autowired
    public CustomerService(CustomerDAO cd) {
        this.cd = cd;
    }

    // Register a new customer
    public Customer registerCustomer(Customer customer) {
        Customer existingCustomer = cd.findByUsername(customer.getUsername());
        if (existingCustomer != null) {
            return null; // Customer already exists
        }
        return cd.save(customer);
    }

    // Log in a customer
    public Customer loginCustomer(Customer credentials) {
        Customer customer = cd.findByUsername(credentials.getUsername());
        if (customer != null && customer.getPassword().equals(credentials.getPassword())) {
            return customer;
        }
        return null; // Invalid credentials
    }

    // Get customer by username
    public Customer findCustomerByUsername(String username) {
        return cd.findByUsername(username);
    }

    // Get customer by ID
    public Customer findCustomerById(int id) {
        return cd.findById(id).orElse(null);
    }

    // Update customer
    public Customer updateCustomer(Customer customer) {
        if (cd.existsById(customer.getCustomerID())) {
            return cd.save(customer);
        }
        return null; // Customer does not exist
    }

    // Delete customer
    public void deleteCustomer(int id) {
        cd.deleteById(id);
    }
}