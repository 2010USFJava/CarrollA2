package com.revature.menu;

import java.util.Scanner;
import com.revature.beans.Accounts;

public class Menu {
	
	static Scanner input = new Scanner(System.in);
	
	public static void startupMenu(Accounts account) {
		System.out.println("Select from the options:");
		System.out.println("[1] Withdraw");
		System.out.println("[2] Deposit");
		System.out.println("[3] View balance");
		
		String answer = input.next();
		switch (answer) {
		case "1": 
			System.out.println("How much would you like to withdraw");
			double ans = input.nextDouble();
			account.withdraw(ans);
		case "2":
			System.out.println("How much would you like to deposit");
			ans = input.nextDouble();
			account.deposit(ans);
		case "3":
			System.out.println("Your balance is "+ account.getBalance());
		default: System.out.println("Invalid option"); startupMenu(account);
		}
	}

}
