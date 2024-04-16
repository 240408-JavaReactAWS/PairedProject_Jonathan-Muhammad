package com.example.revature.PairedProject_JonathanMuhammad.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "customerId")
    private int customerId;

    @Column(name = "itemId")
    private int itemId;

    @Column(name = "itemQuantity", nullable = false)
    private int itemQuantity = 0;

    @Column(name = "totalPrice", nullable = false)
    private double totalPrice;

    public Order() {
    }

    public Order(int customerId, int itemId, int itemQuantity) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
    }


    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getTotal() {
        return totalPrice;
    }

    public void setTotal(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}