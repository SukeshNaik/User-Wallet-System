package com.example.walletSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletSystem.entity.User;
import com.example.walletSystem.entity.ResponseAsEntity;
import com.example.walletSystem.exception.CustomerAlreadyExists;
import com.example.walletSystem.exception.CustomerDoesNotExists;
import com.example.walletSystem.service.UserService;

@RestController
public class AuthenticationController {
	@Autowired
	 private UserService userService;
	@PostMapping(value = "/UserRegistration")
    public ResponseEntity<ResponseAsEntity> signUp(@RequestBody User user) {
		
		ResponseAsEntity response=new ResponseAsEntity();		
        try {
            User newCustomer = userService.save(user);
            response.setStatus("200");
            response.setDescription("Sign Up successful!");
            response.setData(newCustomer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(CustomerAlreadyExists e) {
            response.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
    }
	 
	@PostMapping("/login")
   public ResponseEntity<ResponseAsEntity> signIn(@RequestBody User user)
	{
		ResponseAsEntity response=new ResponseAsEntity();		
	String mobileNumber=user.getMobileNumber();
	String password=user.getPassword();
       try {
           User existingCustomer = userService.findBymobileNumber(mobileNumber);
           if((existingCustomer.getPassword().toString()).compareTo(password)==0)
           {
           	response.setStatus("200");
	            response.setDescription(existingCustomer.getUserName()+", you are logged in!");
	            response.setData(existingCustomer);
	            return new ResponseEntity<>(response, HttpStatus.OK);
           }
           else {
           	response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
	            response.setDescription("Incorrect Password !");
	            response.setData(existingCustomer);
	            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
           }
       }
       catch(CustomerDoesNotExists e) {
           response.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
           response.setDescription(e.getMessage());
           return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
       }
       
   }
}
