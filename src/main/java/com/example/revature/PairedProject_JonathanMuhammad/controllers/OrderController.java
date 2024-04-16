package com.example.revature.PairedProject_JonathanMuhammad.controllers;

import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import com.example.revature.PairedProject_JonathanMuhammad.models.Order;
import com.example.revature.PairedProject_JonathanMuhammad.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create an order
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        // Validate order and create
        String result = orderService.createOrder(order);
        if (result.equals("Order placed successfully.")) {
            return ResponseEntity.ok(result);
        } else if (result.equals("Not enough items available.")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        } else if (result.equals("Item not found.")) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get orders by customer
    @GetMapping
    public ResponseEntity<List<Order>> getOrdersByCustomer(@RequestBody Customer customer) {
        List<Order> orders = orderService.getOrders(customer);
        if (orders != null) {
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
