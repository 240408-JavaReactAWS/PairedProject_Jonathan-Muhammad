package com.example.revature.PairedProject_JonathanMuhammad.repos;

import com.example.revature.PairedProject_JonathanMuhammad.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ItemDAO extends JpaRepository<Item, Integer> {


}
