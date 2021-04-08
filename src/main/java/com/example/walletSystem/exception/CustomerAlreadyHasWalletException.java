package com.example.walletSystem.exception;

import com.example.walletSystem.entity.User;

public class CustomerAlreadyHasWalletException extends Exception {
    public CustomerAlreadyHasWalletException(User user) {
        super("User "+user.getUserName()+" already owns a wallet : "+user.getWallet().getWalletId());
    }
}
