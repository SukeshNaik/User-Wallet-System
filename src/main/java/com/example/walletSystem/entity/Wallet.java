package com.example.walletSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

@Entity
public class Wallet implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int walletId;

    @OneToMany(mappedBy = "wallet",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference(value="wallet-account")
    private List<Account> accountsInWallet;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public List<Account> getAccountsInWallet() {
		return accountsInWallet;
	}

	public void setAccountsInWallet(List<Account> accountsInWallet) {
		this.accountsInWallet = accountsInWallet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", accountsInWallet=" + accountsInWallet + ", user=" + user + "]";
	}
  
    
}
