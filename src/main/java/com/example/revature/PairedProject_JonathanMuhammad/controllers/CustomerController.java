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
    OrderService orderService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Get
    @GetMapping
    public ResponseEntity<?> loginCustomer(@RequestBody Customer customer) {
        Customer loginCustomer = customerService.loginCustomer(customer);
        if (loginCustomer != null) {
            return ResponseEntity.ok(loginCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrdersFromUser(@RequestBody Customer customer ) {
        List<Order> orders = orderService.getAllOrders(customer);
        return ResponseEntity.ok(orders);
    }
    // Input Username Password to get other details

    // Post
    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        // Input validation
        if (customer.getUsername().isBlank() || customer.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("");
        }

        // Check if customer already exists
        Customer existingCustomer = customerService.findCustomerByUsername(customer.getUsername());
        if (existingCustomer != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("");
        }

        Customer registeredCustomer = customerService.registerCustomer(customer);
        return ResponseEntity.ok(registeredCustomer);

    }


}
