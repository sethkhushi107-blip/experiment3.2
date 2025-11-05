package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double balance;

    public Account() {}

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
