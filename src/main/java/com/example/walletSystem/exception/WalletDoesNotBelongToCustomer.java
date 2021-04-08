package com.example.walletSystem.exception;

import com.example.walletSystem.entity.User;
import com.example.walletSystem.entity.Wallet;

public class WalletDoesNotBelongToCustomer extends Exception {
    public WalletDoesNotBelongToCustomer(User user, Wallet wallet) {
        super("User with id"+user.getUserId()+" does not have associated walletId : "+wallet.getWalletId());
    }
}
