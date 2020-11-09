package com.revature.bank.menu;

import java.util.Scanner;

import com.revature.bank.beans.Account;
import com.revature.bank.beans.AccountRequest;
import com.revature.bank.beans.User;
import com.revature.bank.util.Filing;
import com.revature.bank.util.Logging;
import com.revature.bank.util.Verify;

public class MenuMethod {
	static Scanner input = new Scanner(System.in);
	
	public static void login() {
		String answer;
		do {
			System.out.println("Enter username, or [1] to quit.");
			answer = input.next();
			//check username and password
			for (int i=0; i<Verify.userList.size(); i++) {
				if (answer.equals(Verify.userList.get(i).getUsername())) {
					System.out.println("Enter Password");
					answer = input.next();
					if (answer.equals(Verify.userList.get(i).getPassword())) {
						//enter menu based on type of user
						if (Verify.userList.get(i).getType().equalsIgnoreCase("Admin")) {
							OptionMenu.adminMenu();
						}else if (Verify.userList.get(i).getType().equalsIgnoreCase("Employee")){
							OptionMenu.employeeMenu();
						} else {
							OptionMenu.customerMenu(Verify.userList.get(i));
						}
					}else {
						System.out.println("Invalid password");
						login();
					}
				}
			}
			System.out.println("Invalid username");
		} while (!(answer.equals("1")));
		OptionMenu.startup();	
	}
	public static void register(String type) {
		//input new customer info
		System.out.println("Enter your first and last name.");
		String firstName = input.next();
		String lastName = input.next();
		System.out.println("Enter street address.");
		String dummyLine = input.nextLine(); //place holder for delimiter
		String street = input.nextLine();
		System.out.println("Enter city state and zip, without commas.");
		String city = input.next();
		String state = input.next();
		String zip = input.next();
		//check if zipcode is 5 digits
		while (!(Verify.verifyNum(zip)) || zip.length() != 5) {
			System.out.println("Enter 5 digits for zipcode");
			zip = input.next();
		}
		System.out.println("Enter social security number (e.g. 000-00-0000)");
		String ss = input.next();
		//check if social security matches format
		while (!(ss.matches("\\d{3}-\\d{2}-\\d{4}"))) {
			System.out.println("Enter social security using dashes in this format: 000-00-0000");
			ss = input.next();
		}
		System.out.println("Enter a new username.");
		String username = input.next();
		//check for original username
		while (Verify.usernames.contains(username)) {
			System.out.println("Username already in use.");
			System.out.println("Enter a different username.");
			username = input.next();
		} 
		System.out.println("Enter a new password.");
		String password = input.next();	
		//assign customer ID and check for duplicates
		String userId = "3" + (int)(Math.random()*10000);	
		while (Verify.userIds.contains(userId)){
			userId = "3" + (int)(Math.random()*10000);
		}
		//create new customer
		User customer = new User(firstName, lastName, street, city, state,
			zip, ss, userId, username, password, type);
		System.out.println("Account was created successfully. Would you like to enter into account? y/n");
		//enter menu based on type of user
		if (input.next().equalsIgnoreCase("y")) {
			if (type.equalsIgnoreCase("customer")) {
				OptionMenu.customerMenu(customer);
			} else if (type.equalsIgnoreCase("employee")) {
				OptionMenu.employeeMenu();
			} else if (type.equalsIgnoreCase("admin")) {
				OptionMenu.adminMenu();
			}
		}
	}
	public static void makeAccountRequest(User customer) {
		System.out.println("Enter the type of account (checking, savings, or joint), or [1] to quit");
		String answer = input.next();
		if (answer.equals("1")) {
			OptionMenu.customerMenu(customer);
		} else if (answer.equalsIgnoreCase("savings") || answer.equalsIgnoreCase("checking")) {
			AccountRequest request = new AccountRequest(customer,answer);
			System.out.println("Your request have been submited. It will be reviewed shortly.");
		//if joint then enter existing account ID
		} else if (answer.equalsIgnoreCase("joint")) {
			System.out.println("Enter the ID number of the account you would like to joint.");
			String accountId = input.next();
			//make sure only numbers were used
			if (Verify.verifyNum(accountId)) {
				if (Verify.verifyAccount(accountId)) {
					AccountRequest request = new AccountRequest(customer,"joint "+accountId);
					System.out.println("Your request have been submited. It will be reviewed shortly.");
				}else {
					makeAccountRequest(customer);
				}
			} else {
				makeAccountRequest(customer);
			}
		} else {
			System.out.println("Invalid account type.");
			makeAccountRequest(customer);
		}
	}
	public static void viewAccountRequests() {
		//print all request to console
		for (AccountRequest request: Verify.requestList) {
			System.out.println(request);
		}
		OptionMenu.requestMenu();
	}
	public static void approveAccount(String customerId, String type) {
		//check if customer exist, if they do then check account type
		if (Verify.findCustomer(customerId) == null) {
			OptionMenu.requestMenu();
		} else if (type.equalsIgnoreCase(Verify.verifyType(type))) {
			for (AccountRequest request: Verify.findCustomer(customerId).getRequests()) {
				//only approve request that are labeled not reviewed
				if (request.getStatus().equalsIgnoreCase("not reviewed")) {
					//only approve request that not reviewed and that match the type entered
					if (request.getType().equalsIgnoreCase(type) || request.getType().length()==11) {
						if (type.equalsIgnoreCase("joint")) {
							System.out.println("Enter account ID");
							String accountId = input.next();
							//check if letters or special characters are used and that account exist
							if (Verify.verifyNum(accountId) && Verify.accountIds.contains(accountId)) {
								Account account = new Account(accountId, type);
								Verify.findCustomer(customerId).setAccount(account);
								Logging.LogIt("info","Customer ID "+customerId+" account has been approved");
							}
						} else {
							request.setStatus("approved");
							//assign new Id to account
							String newAccountId = "2" + (int)(Math.random()*10000);
							while (Verify.accountIds.contains(newAccountId)){
								newAccountId = "2" + (int)(Math.random()*10000);
							}
							Account account = new Account(newAccountId, type);
							Verify.findCustomer(customerId).setAccount(account);
							Logging.LogIt("info","Customer ID "+customerId+" account has been approved");	
						}	
					}
				}
			}
		}
	}
	public static void denyAccount(String customerId, String type) {
		//check if customer exist, if they do then check account type
		if (Verify.findCustomer(customerId) == null) {
			OptionMenu.requestMenu();
		}
		if (type.equalsIgnoreCase(Verify.verifyType(type))) {
			for (AccountRequest request: Verify.findCustomer(customerId).getRequests()) {
				//only approve request that are labeled not reviewed
				if (request.getStatus().equalsIgnoreCase("not reviewed")) {
					if (request.getType().equalsIgnoreCase(type)) {
						request.setStatus("denied");
						Logging.LogIt("info","Customer ID "+customerId+" account has been denied");
					}
				}
			}
		}
	}
	public static void viewCustomerInfo() {
		System.out.println("\t\t\t\t\t\tBank of the People\n");
		System.out.printf("%-15s%-15s%-25s%-15s%-10s%-10s%-15s%-20s\n", "Last", "First", "Address Line 1", "City", "State", "Zip", "SS#", "Accounts");
		System.out.println("_____________________________________________________________________________________________________________________________________");
		for (int i=0; i< Verify.userList.size(); i++) {
			//only print users that have an account
			if (Verify.userList.get(i).getAccounts().size() != 0) {
			System.out.printf("%-15s%-15s%-25s%-15s%-10s%-10s%-15s%-20s\n", Verify.userList.get(i).getLastName(), Verify.userList.get(i).getFirstName(), Verify.userList.get(i).getStreet(), Verify.userList.get(i).getCity(),
					Verify.userList.get(i).getState(), Verify.userList.get(i).getZip(), Verify.userList.get(i).getSs(), Verify.userList.get(i).getAccounts());
			}
		}
	}
	public static void exit() {
		//save any changes and exit
		Filing.writeUserFile(Verify.userList);
		System.out.println("Good-bye"); 
		System.exit(0);
	}
}
