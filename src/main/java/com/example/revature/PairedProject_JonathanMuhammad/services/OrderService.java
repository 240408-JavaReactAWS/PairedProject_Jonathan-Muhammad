package com.example.revature.PairedProject_JonathanMuhammad.services;

import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import com.example.revature.PairedProject_JonathanMuhammad.models.Order;
import com.example.revature.PairedProject_JonathanMuhammad.repos.CustomerDAO;
import com.example.revature.PairedProject_JonathanMuhammad.repos.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderDAO od;


    @Autowired
    public  OrderService(OrderDAO od){
        this.od = od;

    }

    public List<Order> getAllOrders(Customer customer) {
        return  od.findAll();
    }


    public Order makeOrder (Order order){
        return od.save(order);
    }
}
