package com.example.walletSystem.exception;

import com.example.walletSystem.entity.Account;

public class AccountNotFound extends Exception {

public  AccountNotFound(Account account) {
        
    	super("Account Number"+ account.getAccountNumber()+"does not exist.");
    }
}
