package com.example.walletSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.walletSystem.entity.User;
import com.example.walletSystem.exception.CustomerAlreadyExists;
import com.example.walletSystem.repository.CustomerRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private CustomerRepository customerRepository;
	

	@Override
	public User save(User user)throws CustomerAlreadyExists {
		
			String number=user.getMobileNumber();
	        User c = customerRepository.findCustomerByNumber(number);

	        if (c!= null) {
	            throw new CustomerAlreadyExists(user);
	        }
		return customerRepository.save(user);
	}

	@Override
	public User findBymobileNumber(String number) {
		return  customerRepository.findCustomerByNumber(number);
				
	}

	
}
