package com.Jean.GestaoFinanceira.Repository;

import com.Jean.GestaoFinanceira.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByAccount_User_Id(Long userId);
}
