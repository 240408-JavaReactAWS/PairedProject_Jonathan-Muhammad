package com.example.revature.PairedProject_JonathanMuhammad.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @Column(name = "customerId")
    private int customerID;
    private  String username;
    private  String password;
    private  String role;


    public Customer() {
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Customer(int customerID, String username, String password) {
        this.customerID = customerID;
        this.username = username;
        this.password = password;
    }

    public Customer(int customerID, String username, String password, String role) {
        this.customerID = customerID;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerID == customer.customerID && Objects.equals(username, customer.username) && Objects.equals(password, customer.password) && Objects.equals(role, customer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, username, password, role);
    }
}
