package com.Jean.GestaoFinanceira.Repository;

import com.Jean.GestaoFinanceira.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByName(String name);

}
