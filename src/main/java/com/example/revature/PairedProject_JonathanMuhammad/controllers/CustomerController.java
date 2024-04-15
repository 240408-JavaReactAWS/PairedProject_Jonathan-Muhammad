package com.example.revature.PairedProject_JonathanMuhammad.controllers;

import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import com.example.revature.PairedProject_JonathanMuhammad.models.Order;
import com.example.revature.PairedProject_JonathanMuhammad.services.CustomerService;
import com.example.revature.PairedProject_JonathanMuhammad.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Endpoint to retrieve a customer by username and password
    @GetMapping
    public ResponseEntity<String> getCustomer(@RequestBody Customer customer) {
        Customer retrievedCustomer = customerService.findCustomerByUsername(customer.getUsername());
        // Check if the customer exists and the password matches
        if (retrievedCustomer != null && retrievedCustomer.getPassword().equals(customer.getPassword())) {
            return ResponseEntity.ok("OK"); // Return OK if authentication succeeds
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized"); // Return Unauthorized otherwise
    }

    // Endpoint to create a customer
    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        // Input validation
        if (customer.getUsername().isBlank() || customer.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("");
        }

        Customer createdCustomer = customerService.registerCustomer(customer);
        // Check if the customer was successfully created
        if (createdCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer); // Return created customer if successful
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Return Conflict if customer already exists

    }

    // Endpoint to update a customer
    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        // Input validation
        if (customer.getUsername().isBlank() || customer.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("");
        }

        Customer updatedCustomer = customerService.updateCustomer(customer);
        // Check if the customer exists and was successfully updated
        if (updatedCustomer != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer.toString()); // Return updated customer if update succeeds
        }
        return ResponseEntity.notFound().build(); // Return Not Found otherwise
    }

    // Endpoint to delete a customer
    @DeleteMapping
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) {
        Customer retrievedCustomer = customerService.findCustomerByUsername(customer.getUsername());
        // Check if the customer exists and the password matches
        if (retrievedCustomer != null && retrievedCustomer.getPassword().equals(customer.getPassword())) {
            customerService.deleteCustomer(retrievedCustomer.getCustomerID());
            return ResponseEntity.ok(retrievedCustomer.toString()); // Return OK if deletion succeeds
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized"); // Return Unauthorized otherwise

    }


}
