package com.revature.beans;

import com.revature.util.AccountList;
import com.revature.util.Files;
import com.revature.util.Logs;

public class Accounts {
	private String Id;
	private double balance;
	private String type;

	public Accounts() {

	}
	public Accounts(String id, double balance, String type) {
		Id = id;
		this.balance = balance;
		this.type = type;
		AccountList.accountList.add(this);
		Files.writeFile(AccountList.accountList);
		Logs.LogIt("info", "A new account was created");
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	public void deposit(double amount) {
		this.balance += amount;
	}

}
