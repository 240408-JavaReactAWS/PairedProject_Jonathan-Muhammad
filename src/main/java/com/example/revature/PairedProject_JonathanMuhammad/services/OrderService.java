package com.example.revature.PairedProject_JonathanMuhammad.services;

import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import com.example.revature.PairedProject_JonathanMuhammad.models.Item;
import com.example.revature.PairedProject_JonathanMuhammad.models.Order;
import com.example.revature.PairedProject_JonathanMuhammad.repos.CustomerDAO;
import com.example.revature.PairedProject_JonathanMuhammad.repos.ItemDAO;
import com.example.revature.PairedProject_JonathanMuhammad.repos.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderDAO orderDAO;
    private ItemDAO itemDAO;
    private CustomerDAO customerDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO, ItemDAO itemDAO, CustomerDAO customerDAO) {
        this.orderDAO = orderDAO;
        this.itemDAO = itemDAO;
        this.customerDAO = customerDAO;
    }

    // Create a new order
    public String createOrder(Order order) {
        // Check if enough items are available
        Optional<Item> itemOptional = itemDAO.findById(order.getItemId());
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            if (item.getItemStock() >= order.getItemQuantity()) {
                // Reduce item stock and save order
                item.setItemStock(item.getItemStock() - order.getItemQuantity());
                order.setTotal(order.getItemQuantity() * item.getItemPrice());
                orderDAO.save(order);
                return "Order placed successfully.";
            } else {
                return "Not enough items available.";
            }
        } else {
            return "Item not found.";
        }
    }

    // Get orders by customer
    public List<Order> getOrders(Customer customerParam) {
        // Check if the customer exists
        Customer customer = customerDAO.findByUsername(customerParam.getUsername());
        if (customer != null && customer.getPassword().equals(customerParam.getPassword())) {
            // If the customer is an ADMIN, return all orders
            if ("ADMIN".equals(customer.getRole())) {
                return orderDAO.findAll();
            } else {
                // If the customer is a USER, return orders with the given customerId
                return orderDAO.findByCustomerId(customer.getCustomerID());
            }
        }
        return null; // Invalid credentials
    }


}
