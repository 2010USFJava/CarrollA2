package com.revature.bank.bean;

import java.sql.Date;
import java.sql.Time;

import com.revature.bank.util.Verify;

public class Transaction {
	private int accountId;
	private String username;
	private double amount;
	private Date date;
	private Time time;
	
	public Transaction() {
	
	}
	public Transaction(int accountId,String username, double amount) {
		
		this.accountId = accountId;
		this.username = username;
		this.amount = amount;
	}
	public Transaction(int accountId, String username, double amount, Date date, Time time) {
	
		this.accountId = accountId;
		this.username = username;
		this.amount = amount;
		this.date = date;
		this.time = time;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUserUsername(String Username) {
		this.username = username;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Transaction [Made on "+date+" at "+time+" by user ID = "+username+" in account "+Verify.findAccount(String.valueOf(accountId))+" in the amount of $"+amount+"]";
	}
	
	
	

}
