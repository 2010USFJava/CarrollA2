package com.revature.bank;

import java.util.Scanner;

public class Menus {
	static Scanner input = new Scanner(System.in);

	public static int login() {
		System.out.println("Enter username.");
		String answer = input.next();
		int i;
		for (i=0; i<User.usernames.size(); i++) {
			if (answer.equals(User.usernames.get(i))) {
				System.out.println("Enter Password");
				answer = input.next();
				if (answer.equals(User.passwords.get(i))) {
					System.out.println("Logged in");
					break;
				}else {
					System.out.println("Invalid ");
					System.exit(0);
				}	
			}
		}
		return i;
	}
	public static void register() {
		//input new customer info
		System.out.println("Enter your first and last name.");
		String firstName = input.next();
		String lastName = input.next();
		System.out.println("Enter street address.");
		String dummyLine = input.nextLine(); //place holder for delimiter
		String street = input.nextLine();
		System.out.println(street);
		System.out.println("Enter city state and zip, without commas.");
		String city = input.next();
		String state = input.next();
		String zip = input.next();	
		System.out.println("Enter a new username.");
		String username = input.next();
		//check for original username
		do {
			if (User.usernames.contains(username)) {
				System.out.println("Username already in use.");
				System.out.println("Enter a different username.");
				username = input.next();
			}
		} while (User.usernames.contains(username));
		System.out.println("Enter a new password.");
		String password = input.next();
		//assign customer ID and check for duplicates
		String idString = "3" + (int)(Math.random()*10000);
		Integer customerId = Integer.valueOf(idString);
		while (User.userIds.contains(customerId)){
			idString = "3" + (int)(Math.random()*10000);
			customerId = Integer.valueOf(idString);
		}
		//create new customer
		Customer customer = new Customer(firstName, lastName, street, city, state,
			zip, customerId, username, password);

	}
}
