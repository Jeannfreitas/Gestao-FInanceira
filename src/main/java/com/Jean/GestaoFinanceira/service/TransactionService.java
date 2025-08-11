package com.Jean.GestaoFinanceira.service;


import com.Jean.GestaoFinanceira.Repository.TransactionRepository;
import com.Jean.GestaoFinanceira.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    // Repositório injetado para operações com o banco de dados
    private final TransactionRepository transactionRepository;

    // Construtor para injeção de dependência
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Método para buscar todas as transações
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    // Método para buscar uma transação por ID
    public Optional<Transaction> findById(long id) {
        return transactionRepository.findById(id);
    }

    // Método para salvar uma nova transação ou atualizar existente
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Método para deletar uma transação por ID
    public void deleteById(long id) {
        transactionRepository.deleteById(id);
    }
}
