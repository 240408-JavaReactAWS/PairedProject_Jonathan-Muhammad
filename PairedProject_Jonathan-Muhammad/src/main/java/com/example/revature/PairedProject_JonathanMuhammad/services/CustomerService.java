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
    public  CustomerService(CustomerDAO cd){
        this.cd = cd;
    }

    //Log In
    //Create Customer
    //

    public Customer registerCustomer(Customer customer) {
        return cd.save(customer);
    }

    public Customer loginCustomer(Customer credentials) {
        Customer Customer = cd.findByUsername(credentials.getUsername());
        if (Customer != null && Customer.getPassword().equals(credentials.getPassword())) {
            return Customer;
        }
        return null;
    }

    public Customer findCustomerByUsername(String username) {
        return cd.findByUsername(username);
    }

    public Customer findCustomerById(int id) {
        return cd.findById(id).orElse(null);
    }
}
