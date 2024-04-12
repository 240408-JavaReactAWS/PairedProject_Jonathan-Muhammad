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
    private CustomerDAO cd;

    @Autowired
    public  OrderService(OrderDAO od, CustomerDAO cd){
        this.od = od;
        this.cd = cd;
    }

    public List<Order> getAllOrders(Customer customer) {
        Customer Customer = cd.findByUsername(customer.getUsername());
        if (Customer != null && Customer.getPassword().equals(customer.getPassword()) && Customer.getRole().equals("ADMIN")) {
            return  od.findAll();
        }
        return  null;
    }

    public List<Order> getAllOrdersFromCustomer(Customer customer) {
        Customer Customer = cd.findByUsername(customer.getUsername());
        if (Customer != null && Customer.getPassword().equals(customer.getPassword()) ) {
            return  od.findByCustomerId(customer.getCustomerID());
        }
        return  null;
    }

    public Order makeOrder (Order order){
        return od.save(order);
    }
}
