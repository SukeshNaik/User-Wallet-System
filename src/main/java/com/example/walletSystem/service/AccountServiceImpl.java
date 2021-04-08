package com.example.walletSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.walletSystem.entity.Account;
import com.example.walletSystem.entity.User;
import com.example.walletSystem.exception.AccountNotFound;
import com.example.walletSystem.exception.CustomerDoesNotExists;
import com.example.walletSystem.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
    AccountRepository accountRepository;
	
	@Autowired
    UserService userService;
	
	@Override
	public Account save(Account account)  {
		
		return accountRepository.save(account);
	}

	@Override
	public List<Account> findAccountByNumber(int accountNumber) throws AccountNotFound {
		
		return accountRepository.findAccountByNumber(accountNumber);
	}

}
