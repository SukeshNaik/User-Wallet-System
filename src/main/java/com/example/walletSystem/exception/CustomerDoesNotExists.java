package com.example.walletSystem.exception;

import com.example.walletSystem.entity.User;

public class CustomerDoesNotExists extends Exception {

public  CustomerDoesNotExists(User user) {
        
    	super("User "+user.getMobileNumber()+" does not exist. Please Sign up to avail the service.");
    }
}
