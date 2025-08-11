package com.Jean.GestaoFinanceira.Repository;

import com.Jean.GestaoFinanceira.model.Category;
import com.Jean.GestaoFinanceira.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByType(TransactionType type);
}
