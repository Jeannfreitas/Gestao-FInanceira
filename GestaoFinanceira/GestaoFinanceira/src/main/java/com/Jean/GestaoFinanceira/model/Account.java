package com.Jean.GestaoFinanceira.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")


public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal initialBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account(Long id, String name, BigDecimal initialBalance, User user) {
        this.id = id;
        this.name = name;
        this.initialBalance = initialBalance;
        this.user = user;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

