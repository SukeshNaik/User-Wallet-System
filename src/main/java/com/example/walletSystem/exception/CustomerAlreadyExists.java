package com.example.walletSystem.exception;

import com.example.walletSystem.entity.User;

public class CustomerAlreadyExists extends Exception {
	
    public  CustomerAlreadyExists(User user) {
        
    	super("User "+user.getMobileNumber()+" already exists by the name "+user.getUserName()+". Please Sign in to make transactions.");
    }

}
