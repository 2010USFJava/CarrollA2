package com.revature.bank;

public class Account {
	private int accountId;
	private double balance;
	
	protected Account() {
		
	}
	protected Account(int accountId, double balance) {
		this.accountId = accountId;
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void withdraw(double amount) {
		balance -= amount;
		if (balance < 0) {
			System.out.println("insuffiencent funds");
			balance += amount; 
		}
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public void transfer(double amount, int accountId) {
		
	}

}

