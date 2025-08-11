package com.Jean.GestaoFinanceira.Repository;

import com.Jean.GestaoFinanceira.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccount_User_Id(Long userId);

}
