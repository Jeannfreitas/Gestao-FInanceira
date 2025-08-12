package com.Jean.GestaoFinanceira.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotNull(message = "Value is mandatory")
    @Positive(message = "Value must be positive")
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type is mandatory")
    private TransactionType type;
    private LocalDateTime date = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Description is mandatory") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is mandatory") String description) {
        this.description = description;
    }

    public @NotNull(message = "Value is mandatory") @Positive(message = "Value must be positive") BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "Value is mandatory") @Positive(message = "Value must be positive") BigDecimal amount) {
        this.amount = amount;
    }

    public @NotNull(message = "Type is mandatory") TransactionType getType() {
        return type;
    }

    public void setType(@NotNull(message = "Type is mandatory") TransactionType type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

