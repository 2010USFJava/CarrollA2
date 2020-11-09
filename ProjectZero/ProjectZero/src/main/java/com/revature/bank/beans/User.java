package com.revature.bank.beans;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import com.revature.bank.util.Filing;
import com.revature.bank.util.Logging;
import com.revature.bank.util.Verify;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private transient String ss;
	private String userId;
	private String username;
	private String password;
	private String type;
	private List<Account> accounts = new ArrayList<>();
	private List<AccountRequest> requests = new ArrayList<>();
	
	public User() {
		Verify.userList.add(this);
	}
	public User(String firstName, String lastName, String street, String city, String state,
			String zip, String ss, String userId, String username, String password, String type) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ss = ss;
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.type = type;
		Verify.userList.add(this);
		Filing.writeUserFile(Verify.userList);
		Logging.LogIt("info","A new "+this.type+", " +this.firstName+" "+this.lastName+", has been created.\n");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		Logging.LogIt("info", this.type+", Id "+this.userId+" has updated first name to" + this.firstName+"\n");
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		Logging.LogIt("info", this.type+", Id "+this.userId+" has updated last name to" + this.lastName+"\n");
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
		Logging.LogIt("info", this.type+", Id "+this.userId+" has updated stree address to" + this.street+"\n");
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
		Logging.LogIt("info", this.type+", Id "+this.userId+" has updated city to" + this.city+"\n");
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
		Logging.LogIt("info", this.type+", Id "+this.getUserId()+" has updated state to" + this.state+"\n");
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
		Logging.LogIt("info", this.type+", Id "+this.getUserId()+" has updated zipcode to" + this.zip+"\n");
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
		Logging.LogIt("info", this.firstName+" "+this.lastName+"'s user ID has been changed to "+this.userId+"\n");
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
		Logging.LogIt("info", this.type+", Id "+this.userId+", username has been changed to "+this.username+"\n");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		Logging.LogIt("info", this.type+", Id "+this.userId+", password has been changed to "+this.password+"\n");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccount(Account account) {
		this.accounts.add(account);
		Logging.LogIt("info", account+" has been added to "+this.type+", Id "+this.getUserId()+"\n");
	}
	public List<AccountRequest> getRequests() {
		return requests;
	}
	public void setRequests(AccountRequest request) {
		this.requests.add(request);
		Logging.LogIt("info", request+" has been made.\n");
	}
	@Override
	public String toString() {
		return this.lastName + " " + this.firstName + " = " + this.userId;
	}
	
}
