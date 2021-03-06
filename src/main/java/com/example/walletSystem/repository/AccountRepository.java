package com.example.walletSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.walletSystem.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query("SELECT a FROM Account  a WHERE a.accountNumber=:accountNumber")
    List<Account> findAccountByNumber(@Param("accountNumber") Integer accountNumber);
}
