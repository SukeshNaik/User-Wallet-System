package com.example.walletSystem.comparator;


import java.util.Comparator;

import com.example.walletSystem.entity.Transactions;

public class BankTransactionSortingComparator implements Comparator<Transactions> {

    public int compare(Transactions t1, Transactions t2) {
        return t2.getTimestamp().compareTo(t1.getTimestamp());
    }
}
