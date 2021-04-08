package com.example.walletSystem.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.walletSystem.entity.Transactions;

public interface TansactionsRepository extends CrudRepository<Transactions, Integer> {
    @Query("SELECT t FROM Transactions t WHERE t.transactionId=:transactionId")
    Iterable<Transactions> findBankTransactionById(@Param("transactionId") Integer transactionId);
}
