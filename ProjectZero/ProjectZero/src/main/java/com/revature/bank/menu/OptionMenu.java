package com.revature.bank.menu;

import java.util.Scanner;

import com.revature.bank.beans.Account;
import com.revature.bank.beans.User;
import com.revature.bank.util.Verify;

public class OptionMenu {
	static Scanner input = new Scanner(System.in);
	
	public static void startup() {
		System.out.println("Welcome to Bank of the People\n");
		System.out.println("Select from options:\n");
		System.out.println("\t[1] Login");
		System.out.println("\t[2] Register as new customer");
		System.out.println("\t[3] Quit\n");
		String answer = input.next();
		switch (answer) {
		case "1": MenuMethod.login(); break;
		case "2": MenuMethod.register("CUSTOMER"); System.exit(0);
		case "3": MenuMethod.exit();
		default: System.out.println("Please enter a 1, 2, 3, or 4.\n"); startup();
		}
	}
	public static void customerMenu(User customer) {
		System.out.println("Hello " + customer.getFirstName() + ", please select from options:\n");
		System.out.println("\t[1] View accounts");
		System.out.println("\t[2] Make account request");
		System.out.println("\t[3] Quit\n");
		String answer = input.next();
		switch (answer) {
		case "1":
			if (customer.getAccounts().size() == 0) {
				System.out.println("Account has not been reviewed yet or has been denied.\n");
			} else {
				System.out.println("Your accounts are " + customer.getAccounts()+". Enter the ID number of the account.");
				answer = input.next();
				//check if account exist
				if (Verify.verifyAccount(answer)) {
					accountMenu(Verify.findAccount(answer));
					customerMenu(customer);
				}
			}
			customerMenu(customer); break;
		case "2": MenuMethod.makeAccountRequest(customer); customerMenu(customer); break;
		case "3": MenuMethod.exit();
		default: System.out.println("Please enter 1, 2, 3, or 4.\n"); customerMenu(customer);
		}
	}
	public static void employeeMenu() {
		System.out.println("Select from options:\n");
		System.out.println("\t[1] View customer accounts");
		System.out.println("\t[2] View account request");
		System.out.println("\t[3] Quit\n");
		String answer = input.next();
		switch (answer) {
		case "1": MenuMethod.viewCustomerInfo(); employeeMenu(); break;
		case "2": MenuMethod.viewAccountRequests(); employeeMenu(); break;
		case "3": MenuMethod.exit();
		default: System.out.println("Please enter 1, 2, or 3.\n"); employeeMenu();
		}
	}
	public static void adminMenu() {
		System.out.println("Select from options:\n");
		System.out.println("\t[1] View customer accounts");
		System.out.println("\t[2] View account request");
		System.out.println("\t[3] Enter into customer account");
		System.out.println("\t[4] Register new employee or customer");
		System.out.println("\t[5] Cancel account");
		System.out.println("\t[6] Quit\n");
		String answer = input.next();
		switch (answer) {
		case "1": MenuMethod.viewCustomerInfo(); adminMenu(); break;
		case "2": MenuMethod.viewAccountRequests(); adminMenu(); break;
		case "3":
			System.out.println("Enter account Id");
			answer = input.next();
			if (Verify.verifyAccount(answer)) {
				accountMenu(Verify.findAccount(answer));
			}
			adminMenu(); break;
		case "4":
			System.out.println("Enter type of user.");
			answer = input.next();
			if (answer.equalsIgnoreCase(Verify.verifyType(answer))) {
				MenuMethod.register(Verify.verifyType(answer));
			}
			adminMenu(); break;
		case "5": MenuMethod.cancelAccount(); adminMenu(); break;
		case "6" : MenuMethod.exit();
		default: System.out.println("Please enter 1, 2, 3, 4, or 5.\n"); adminMenu();
		}
	}
	public static void accountMenu(Account account) {
		System.out.println("Select from options:\n");
		System.out.println("\t[1] Withdraw");
		System.out.println("\t[2] Deposit");
		System.out.println("\t[3] Transfer");
		System.out.println("\t[4] View account balance");
		System.out.println("\t[5] Quit\n");
		String answer = input.next();
		switch (answer) {
		case "1": 
			System.out.println("Enter amount to withdraw. Enter amount without decimals (e.g 100.00 = 10000).");
			answer = input.next();
			account.withdraw(answer);
			transactionMenu(account); 
			break;
		case "2": 
			System.out.println("Enter amount to deposit. Enter amount without decimals (e.g 100.00 = 10000).");
			answer = input.next();
			account.deposit(answer);
			transactionMenu(account); 
			break;
		case "3":
			System.out.println("Enter ID number of account receiving tranfer");
			String accountId = input.next();
			System.out.println("Enter amount to transfer. Enter amount without decimals (e.g 100.00 = 10000).");
			answer = input.next();
			account.transfer(accountId, answer);
			transactionMenu(account);
			break;
		case "4": 
			System.out.println("Your balance is $" + account.getBalance()+"\n");
			transactionMenu(account); break;
		case "5": MenuMethod.exit();
		default: System.out.println("Please enter 1, 2, 3, 4, or 5.\n"); accountMenu(account);
		}
	}
	public static void transactionMenu(Account account) {
		System.out.println("Would you like to make another transaction in this account? y/n");
		String answer = input.next();
		if (answer.equalsIgnoreCase("y")) {
			accountMenu(account);
		}
	}
	public static void requestMenu() {
		System.out.println("Select an option:\n");
		System.out.println("\t[1] Approve a request");
		System.out.println("\t[2] Deny a request");
		System.out.println("\t[3] Return to previous menu\n");
		String answer = input.next();
		switch (answer) {
		case "1": 
			System.out.println("Enter customer Id and type of account");
			answer = input.next();
			String type = input.next();
			MenuMethod.approveAccount(answer, type); requestMenu(); break;
		case "2": 
			System.out.println("Enter customer Id and type of account");
			answer = input.next();
			type = input.next();
			MenuMethod.denyAccount(answer, type); requestMenu(); break;
		case "3": break;
		default: System.out.println("Please enter 1, 2, or 3.\n"); requestMenu();
		}
	}
}
