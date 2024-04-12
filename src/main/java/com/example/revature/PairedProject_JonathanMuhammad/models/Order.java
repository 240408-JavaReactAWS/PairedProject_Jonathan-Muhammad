package com.example.revature.PairedProject_JonathanMuhammad.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    public Order() {
    }

    public Order(int orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}