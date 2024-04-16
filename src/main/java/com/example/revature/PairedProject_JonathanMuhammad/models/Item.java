package com.example.revature.PairedProject_JonathanMuhammad.models;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int itemId;
    String itemName;
    double itemPrice;
    String itemDescription;
    int itemStock;

    public Item() {
    }

    public Item(String itemName, double itemPrice, String itemDescription, int itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemStock = itemStock;
    }

    public Item(int itemId, String itemName, double itemPrice, String itemDescription, int itemStock) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemStock = itemStock;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemStock=" + itemStock +
                '}';
    }
}

