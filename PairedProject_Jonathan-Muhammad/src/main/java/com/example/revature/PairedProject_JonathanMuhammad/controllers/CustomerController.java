package com.example.revature.PairedProject_JonathanMuhammad.controllers;

import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import com.example.revature.PairedProject_JonathanMuhammad.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Get
    @GetMapping("/customer")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer customer) {
        Customer loginCustomer = customerService.loginCustomer(customer);
        if (loginCustomer != null) {
            return ResponseEntity.ok(loginCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        }
    }
    // Input Username Password to get other details

    // Post

}
