package com.example.walletSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transactions implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int transactionId;
    private String Type;
    private Date timestamp;
    private float transactionAmount;
    private String transactionStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Account account;
    
    

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(String typeOfTransaction, Date date, float amount, float postBalance, String description,
			String status, Account associatedAccount) {
		// TODO Auto-generated constructor stub
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", Type=" + Type + ", timestamp=" + timestamp
				+ ", transactionAmount=" + transactionAmount + ", transactionStatus=" + transactionStatus + ", account="
				+ account + "]";
	}

    

}
