package com.revature.bank.beans;

import java.io.Serializable;

public class AccountRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User customer;
	private String type;
	private String status = "not reviewed";
	
	public AccountRequest() {

	}
	public AccountRequest(User customer, String type) {
		this.customer = customer;
		this.type = type;
		customer.setRequests(this);
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AccountRequest [customer = " + customer + ", type = " + type + ", status = " + status + "]";
	}
	
	

}
