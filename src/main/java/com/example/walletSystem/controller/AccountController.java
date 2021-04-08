package com.example.walletSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletSystem.entity.Account;
import com.example.walletSystem.entity.ResponseAsEntity;
import com.example.walletSystem.exception.CustomerDoesNotExists;
import com.example.walletSystem.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value="/createUserAccount")
    public ResponseEntity<ResponseAsEntity> createAccount(@RequestBody Account account) {
		ResponseAsEntity response=new ResponseAsEntity();		
       
		
            Account newAcount = accountService.save(account);
            response.setStatus("200");
            response.setDescription("User Account created successfully!");
            response.setData(newAcount);
            return new ResponseEntity<>(response, HttpStatus.OK);
        
    }

}
