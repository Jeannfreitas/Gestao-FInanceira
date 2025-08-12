package com.Jean.GestaoFinanceira.controller;

import com.Jean.GestaoFinanceira.model.Transaction;
import com.Jean.GestaoFinanceira.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable int id) {
        return transactionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.save(transaction);
        return ResponseEntity.status(201).body(savedTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @Valid @RequestBody Transaction transaction) {
        return transactionService.findById(id)
                .map(existingTransaction -> {
                    existingTransaction.setDescription(transaction.getDescription());
                    existingTransaction.setAmount(transaction.getAmount());
                    existingTransaction.setDate(transaction.getDate());
                    existingTransaction.setType(transaction.getType());
                    existingTransaction.setCategory(transaction.getCategory());
                    existingTransaction.setAccount(transaction.getAccount());
                    Transaction updated = transactionService.save(existingTransaction);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (transactionService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        transactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
