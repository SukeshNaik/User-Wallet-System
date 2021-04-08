package com.example.walletSystem.service;

import java.util.List;

import com.example.walletSystem.entity.Account;
import com.example.walletSystem.exception.AccountNotFound;

public interface AccountService {

	Account save(Account account);

	List<Account> findAccountByNumber(int accountNumber) throws AccountNotFound;
}
