package com.example.revature.PairedProject_JonathanMuhammad.repos;


import com.example.revature.PairedProject_JonathanMuhammad.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrderDAO extends JpaRepository<Order, Integer> {


}
