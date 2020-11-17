package com.revature.bank.menu;

import java.util.Scanner;

import com.revature.bank.bean.Account;
import com.revature.bank.bean.User;
import com.revature.bank.util.Logging;
import com.revature.bank.util.Verify;

public class MenuMethod {
	static Scanner input = new Scanner(System.in);
	
	public static void login() {
		String answer;
		do {
			System.out.println("Enter username, or [1] to go to previous menu.");
			answer = input.nextLine();
			//check username and password
			if (Verify.isUsernameInDatabase(answer)) {
				User user = Verify.findUser(answer);
				System.out.println("Enter Password");
				answer = input.nextLine();
				if (answer.equals(user.getPassword())) {
					//enter menu based on type of user
					if (user.getType().equalsIgnoreCase("Employee")){
						OptionMenu.employeeMenu(user);
						Logging.LogIt("info","An " +user.getType()+ ", username = "+user.getUsername()+", has logged in.");
					} else {
						OptionMenu.customerMenu(user);
						Logging.LogIt("info","A " +user.getType()+ ", username = "+user.getUsername()+", has logged in.");
					}
				}else {
					System.out.println("Invalid password\n");
					login();
				}
			}
		} while (!(answer.equals("1")));
		OptionMenu.startup();	
	}
	public static void register(String type) {
		//input new customer info
		System.out.println("Enter your first name.");
		String firstName = input.nextLine();
		System.out.println("Enter your last name.");
		String lastName = input.nextLine();
		System.out.println("Enter social security number (e.g. 000-00-0000)");
		String ss = input.nextLine();
		//check if social security matches format
		while (!(ss.matches("\\d{3}-\\d{2}-\\d{4}"))) {
			System.out.println("Incorrect");
			System.out.println("Enter social security using dashes in this format: 000-00-0000");
			ss = input.nextLine();
		}
		System.out.println("Enter street address.");
		String street = input.nextLine();
		System.out.println("Enter city state and zip, without commas.");
		String city = input.nextLine();
		String state = input.nextLine();
		String zip = input.nextLine();
		//check if zipcode is 5 digits
		while (!(Verify.verifyNum(zip)) || zip.length() != 5) {
			System.out.println("Enter 5 digits for zipcode");
			zip = input.nextLine();
		}
		System.out.println("Enter a new username.");
		String username = input.nextLine();
		//check for original username
		while (Verify.isUsernameInDatabase(username)) {
			System.out.println("Username is already in use.");
			System.out.println("Enter a different username.");
			username = input.nextLine();
		} 
		System.out.println("Enter a new password.");
		String password = input.nextLine();	
		//create new user and add to database
		User user = new User(firstName, lastName, ss, street, city, state, Integer.valueOf(zip), username, password, type);
		Verify.addUserToDatabase(user);
		System.out.println("Account was created successfully. Would you like to enter into account? y/n");
		//enter menu based on type of user
		if (input.nextLine().equalsIgnoreCase("y")) {
			if (type.equalsIgnoreCase("customer")) {
				OptionMenu.customerMenu(user);
			} else if (type.equalsIgnoreCase("employee")) {
				OptionMenu.employeeMenu(user);
			}
		}
	}
	public static void newAccount(User customer) {
		System.out.println("Enter the type of account you would like to open. (e.g. checking, saving, joint)");
		String answer = input.nextLine();
		if (answer.equalsIgnoreCase(Verify.verifyType(answer))) {
			Account account = new Account(Verify.verifyType(answer), customer.getUsername());
			//get generated account id from database and add it to account object
			int id = Verify.addAccountToGetId(account);
			account.setAccountId(id);
			customer.addAccountToCustomer(account);
			Verify.addToUserAccountTable(account.getAccountId(), customer.getUsername());
		}
	}
	public static void viewAllCustomerInfo() {
		Verify.getCustomers();
		System.out.println("\t\t\t\t\t\tBank of the People\n");
		System.out.printf("%-15s%-15s%-25s%-15s%-10s%-10s%-10s%-20s\n", "Last", "First", "Address Line 1", "City", "State", "Zip", "SS#", "Accounts");
		System.out.println("_____________________________________________________________________________________________________________________________________");
		for (int i=0; i< Verify.customerList.size(); i++) {
			//only print users that have an account
			if (!(Verify.customerList.get(i).getAccounts().contains(null))) {
			System.out.printf("%-15s%-15s%-25s%-15s%-10s%-10s%-10s%-20s\n", Verify.customerList.get(i).getLastName(), Verify.customerList.get(i).getFirstName(), Verify.customerList.get(i).getStreet(), Verify.customerList.get(i).getCity(),
					Verify.customerList.get(i).getState(), Verify.customerList.get(i).getZip(), Verify.customerList.get(i).getSs(), Verify.customerList.get(i).getAccounts());
			}
		}
	}
	public static void viewProfile(User user) {
		System.out.println("ID = "+user.getUserId());
		System.out.println("Name = "+user.getFirstName()+" "+user.getLastName());
		System.out.println("Street address = "+user.getStreet());
		System.out.println("City = "+user.getCity());
		System.out.println("State = "+user.getState());
		System.out.println("Zip code = "+user.getZip());
		System.out.println("Username = "+user.getUsername());
		System.out.println("Password = "+user.getPassword());
	}
	public static void updateProfile(User user) {
		System.out.println("Enter the field you would like to update (e.g. last name or first name), or [1] to stop updating.");
		String answer = input.nextLine();
		switch (answer.toLowerCase()) {
		case "first name": 
			System.out.println("Enter new first name.");
			String newInfo = input.nextLine();
			user.setFirstName(answer, newInfo); updateProfile(user); break;
		case "last name": 
			System.out.println("Enter new last name.");
			newInfo = input.nextLine();
			user.setLastName(answer, newInfo); updateProfile(user); break;
		case "street address": 
			System.out.println("Enter new street address.");
			newInfo = input.nextLine();
			user.setStreet(answer, newInfo); updateProfile(user); break;
		case "city": 
			System.out.println("Enter new city.");
			newInfo = input.nextLine();
			user.setCity(answer, newInfo); updateProfile(user); break;
		case "state": 
			System.out.println("Enter new state.");
			newInfo = input.nextLine();
			user.setState(answer, newInfo); updateProfile(user); break;
		case "zip code": 
			System.out.println("Enter new zip code.");
			newInfo = input.nextLine();
			if (Verify.verifyNum(newInfo) && newInfo.length() == 5) {
				user.setZip(answer, newInfo);
			} else {
				System.out.println("Zip code must be 5 digits.");
			}
			updateProfile(user); break;
		case "username": 
			System.out.println("Enter new username.");
			newInfo = input.nextLine();
			user.setUsername(answer, newInfo); updateProfile(user); break;
		case "password": 
			System.out.println("Enter new password.");
			newInfo = input.nextLine();
			user.setPassword(answer, newInfo); updateProfile(user); break;
		case "1": break;
		default: System.out.println("Not a valid field name."); updateProfile(user);
		}
	}
	public static void cancelAccount() {
		System.out.println("Enter username.");
		String username = input.nextLine();
		if (Verify.findUser(username) != null) {
			System.out.println("Enter account ID to cancel");
			String accountId = input.nextLine();
			if (Verify.findAccount(accountId).getBalance() == 0) {
				if (Verify.findUser(username).getAccounts().remove(Verify.findAccount(accountId))) {
					Logging.LogIt("info","Customer, username = "+Verify.findUser(username).getUsername()+", account, ID = "+Verify.findAccount(accountId).getAccountId()+", has been cancelled");
					System.out.println(" ");
				} else {
					System.out.println("Transaction incomplete.\n");
				}
			} else {
				System.out.println("Account must be empty to delete. Please withdraw all monies.");
			}
		}
	}
	public static void logOut() {
		//save any changes and exit
		System.out.println("Good-bye"); 
		System.exit(0);
	}
}
