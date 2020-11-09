package com.revature.bank.beans;

import java.io.Serializable;

import com.revature.bank.util.*;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private String accountId;
	private double balance = 0;
	private String type;
	
	public Account() {
		Verify.accountList.add(this);
	}
	public Account(String accountId, String type) {
		this.accountId = accountId;
		this.type = type;
		Verify.accountList.add(this);
		Logging.LogIt("info","A new "+this.type+ " account, ID number "+this.accountId+ ", has been created.");
	}
	public Account(String accountId, String type, String balance) {
		this.accountId = accountId;
		this.type = type;
		this.setBalance(balance);
		Verify.accountList.add(this);
		Logging.LogIt("info","A new "+this.type+ " account, ID number "+this.accountId+ ", has been created.");
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		if (Verify.verifyNum(balance)) {
			String amount = balance.substring(0, balance.length()-2)+"."+balance.substring(balance.length()-2, balance.length());
			this.balance = Double.parseDouble(amount);
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean withdraw(String value) {
		if (Verify.verifyNum(value)) {
			value = value.substring(0, value.length()-2)+"."+value.substring(value.length()-2, value.length());
			double amount = Double.parseDouble(value);
			this.balance -= amount;
			if (this.balance < 0) {
				System.out.println("Transaction incomplete. Insufficient funds\n");
				this.balance += amount; 
			} else {
				Logging.LogIt("info","Account ID, "+this.accountId+" was withdrawn $" + amount + ". The new balance is $" + this.balance+"\n");
				return true;
			}
		}
		return false;
	}
	public void deposit(String value) {
		if (Verify.verifyNum(value)) {
			value = value.substring(0, value.length()-2)+"."+value.substring(value.length()-2, value.length());
			double amount = Double.parseDouble(value);
			this.balance += amount;
			Logging.LogIt("info","Account ID, "+this.accountId+" was deposited $" + amount + ". The new balance is $" + this.balance+"\n");	
		}
	}
	public void transfer(String accountId, String amount) {
		//check if letters were entered and if account exist
		if (Verify.verifyAccount(accountId)) {
			if (this.withdraw(amount) ) {
				Verify.findAccount(accountId).deposit(amount);
				Logging.LogIt("info","Account ID, "+this.accountId+" was withdrawn by transfer $" + amount + ". The new balance is $" + this.balance+"\n");
			}
		}
	}
	@Override
	public String toString() {
		return type + " = " + accountId + " = $" + balance;
	}
}

