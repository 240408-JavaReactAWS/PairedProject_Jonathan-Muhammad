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
@RequestMapping("/orders")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public ResponseEntity<List<Order>> getAllOrdersFromUser(@RequestBody Customer customer ) {
        List<Order> orders = orderService.getAllOrders(customer);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<?> makeOrder(@RequestBody Order order) {

        Order makeOrder = orderService.makeOrder(order);
        return ResponseEntity.ok(makeOrder);

    }
}
