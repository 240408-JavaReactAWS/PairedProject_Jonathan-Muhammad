package com.example.revature.PairedProject_JonathanMuhammad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Item {

    @Id
    private int productId;
    private String productName;
    private double price;
    private String description;
    private int stock;
}
