package com.revature.bank.util;

import java.util.ArrayList;

import java.util.List;

import com.revature.bank.beans.Account;
import com.revature.bank.beans.AccountRequest;
import com.revature.bank.beans.User;

public class Verify {
	public static List<User> userList = new ArrayList<>();
	public static List<String> userIds = new ArrayList<>();
	public static List<String> usernames = new ArrayList<>();
	public static List<String> accountIds = new ArrayList<>();
	public static List<Account> accountList = new ArrayList<>();
	public static List<AccountRequest> requestList = new ArrayList<>();
	
	//check if account exist
	public static boolean verifyAccount(String accountId) {
		if (verifyNum(accountId)) {
			for (int i=0; i<Verify.accountList.size(); i++) {
				if (accountList.get(i).getAccountId().equals(accountId)) {
					return true;
				}
			}
			System.out.println("Invald account ID\n");
		}
		return false;
	}
	public static Account findAccount(String accountId) {
		if (verifyNum(accountId)) {
			for (int i=0; i<accountList.size(); i++) {
				if (accountList.get(i).getAccountId().equals(accountId)) {
					return accountList.get(i);
				}
			}
		}
		return null;
	}
	public static User findCustomer(String customerId) {
		if (verifyNum(customerId)) {
			if (userIds.contains(customerId)) {
				for (int i=0; i<userList.size(); i++) { 
					if (userList.get(i).getUserId().equals(customerId)) {
						return userList.get(i);
					}
				}
			} else {
				System.out.println("Invalid user ID\n");
			}
		}
		return null;
	}
	public static String verifyType (String type) {
		if (type.equalsIgnoreCase("checking") || type.equalsIgnoreCase("savings") || type.equalsIgnoreCase("joint")) {
			return type.toUpperCase();
		} else if (type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("employee") || type.equalsIgnoreCase("admin")) {
			return type.toUpperCase();
		}
		return "Invalid type\n";
	}
	//check if special characters or letters are used
	public static boolean verifyNum(String number) {
		for (int i=0; i< number.length(); i++) {
			if (!(Character.isDigit(number.charAt(i)))) {
				System.out.println("Incomplete. Must use whole numbers only\n");
				return false;
			}
		}
		return true;
	}

}
