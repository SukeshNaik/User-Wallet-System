package com.example.walletSystem.service;

import com.example.walletSystem.entity.User;
import com.example.walletSystem.exception.CustomerAlreadyExists;
import com.example.walletSystem.exception.CustomerDoesNotExists;

public interface UserService {
	
	User save(User user)throws CustomerAlreadyExists;

    User findBymobileNumber(String mobileNumber) throws CustomerDoesNotExists;

}
