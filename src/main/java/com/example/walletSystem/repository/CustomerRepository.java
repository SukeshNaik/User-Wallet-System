package com.example.walletSystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.walletSystem.entity.User;

public interface CustomerRepository extends CrudRepository<User, Integer> {

    @Query("SELECT c FROM User c WHERE c.mobileNumber=:number")
    User findCustomerByNumber(@Param("number") String number);
    }
