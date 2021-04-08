package com.example.walletSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletSystem.entity.Account;
import com.example.walletSystem.entity.ResponseAsEntity;
import com.example.walletSystem.entity.Transactions;
import com.example.walletSystem.entity.Wallet;
import com.example.walletSystem.exception.AccountNotAssociatedWithWalletException;
import com.example.walletSystem.exception.CustomerAlreadyHasWalletException;
import com.example.walletSystem.exception.CustomerDoesNotExists;
import com.example.walletSystem.exception.InsufficientBalanceInWalletException;
import com.example.walletSystem.exception.WalletIdDoesNotExistException;
import com.example.walletSystem.service.WalletService;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    // Create a new wallet for a user. Constraint : A user can have only one wallet
    @PostMapping("/wallet/{userId}")
    public ResponseEntity<ResponseAsEntity> createWallet(@PathVariable("userId") int userId) throws CustomerAlreadyHasWalletException {

    	ResponseAsEntity response = new ResponseAsEntity();

        try {
            Wallet newWallet = walletService.createWallet(userId);
            response.setStatus("200");
            response.setDescription("Wallet created successfully!");
            response.setData(newWallet);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch(CustomerDoesNotExists e) {
            response.setStatus(String.valueOf(HttpStatus.NOT_FOUND));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        catch(CustomerAlreadyHasWalletException e) {
            response.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }

    }

    // Return current account balance - balance in wallet (wallet can have multiple accounts)
    @GetMapping("/wallet/{walletId}/account/{accountId}/balance")
    public  ResponseEntity<ResponseAsEntity>  getAccountBalance (
            @PathVariable("walletId") int walletId,
            @PathVariable("accountId") int accountId){



    	ResponseAsEntity response = new ResponseAsEntity();

        try {
            Float balance = walletService.getAccountBalanceForCurrentWallet(walletId, accountId);
            response.setStatus("200");
            response.setDescription("Balance fetched successfully!!");
            response.setData(balance);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch(WalletIdDoesNotExistException e) {
            response.setStatus(String.valueOf(HttpStatus.NOT_FOUND));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        catch(AccountNotAssociatedWithWalletException e) {
            response.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }

    }


    @PostMapping("/wallet/{fromWalletId}/account/{fromAccountId}/transfer/wallet/{toWalletId}/account/{toAccountId}/amount/{amount}")
    public ResponseEntity<ResponseAsEntity> transfer(@PathVariable ("fromWalletId") int fromWalletId,
                          @PathVariable ("fromAccountId") int fromAccountId,
                          @PathVariable ("toWalletId") int toWalletId,
                          @PathVariable ("toAccountId") int toAccountId,
                          @PathVariable ("amount") float amount) throws WalletIdDoesNotExistException,
            AccountNotAssociatedWithWalletException, InsufficientBalanceInWalletException {

    	ResponseAsEntity response = new ResponseAsEntity();

        try {
            walletService.transferToAccount(fromWalletId, fromAccountId,toWalletId, toAccountId, amount);
            response.setStatus("200");
            response.setDescription("Amount "+ amount+ " transferred successfully!!");
            response.setData(amount);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch(WalletIdDoesNotExistException e) {
            response.setStatus(String.valueOf(HttpStatus.NOT_FOUND));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        catch(AccountNotAssociatedWithWalletException e) {
            response.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }
        catch(InsufficientBalanceInWalletException e) {
            response.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            response.setDescription(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
        }


    }

    

}
