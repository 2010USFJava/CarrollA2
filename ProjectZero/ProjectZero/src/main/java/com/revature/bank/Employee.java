package com.revature.bank;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends User {
	private int employeeId;
	private String username;
	private String password;
	
	protected Employee(int employeeId, String username, String password) {
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
		userIds.add(employeeId);
		usernames.add(username);
		passwords.add(password);
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public void seeRequests() {
		
	}
	public void approveAccount() {
		
	}
	public void denyAccount() {
		
	}
	public void viewCustomer() {
		
	}
	

}
