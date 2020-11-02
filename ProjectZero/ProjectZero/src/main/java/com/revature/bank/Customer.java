package com.revature.bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String username;
	private String password;
	private int customerId;
	private ArrayList<Integer> accountIds;
	
	protected Customer(String firstName, String lastName, String street, String city, String state,
			String zip, int customerId, String username, String password) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		userIds.add(customerId);
		usernames.add(username);
		passwords.add(password);
		customerList.add(this);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public ArrayList<Integer> getAccountId() {
		return accountIds;
	}
	public void setAccountId(Account account) {
		this.accountIds.add(account.getAccountId());
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
