package com.example.revature.PairedProject_JonathanMuhammad.repos;

import com.example.revature.PairedProject_JonathanMuhammad.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CustomerDAO extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);

}
