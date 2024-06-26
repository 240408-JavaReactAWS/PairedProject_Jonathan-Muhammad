package com.example.revature.PairedProject_JonathanMuhammad.repos;


import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import com.example.revature.PairedProject_JonathanMuhammad.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerId(int customerId);
}
