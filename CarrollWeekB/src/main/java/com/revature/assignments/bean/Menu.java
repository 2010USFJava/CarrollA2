package com.revature.assignments.bean;

import java.util.Scanner;

public class Menu {
	static Scanner input = new Scanner(System.in);
	
	public static void startup () {
		System.out.println("Select a menu option:");
		System.out.println("[1] create a new person");
		System.out.println("[2] quit");

		String choice = input.next();
		switch (choice) {
		case "1": create(); break;
		case "2": System.exit(0); break;
		default: startup();
		}
	}
	
	public static void create() {
		System.out.println("Enter first and last name");
		String first = input.next();
		String last = input.next();
		
	
		System.out.println("Enter date of birth (e.g. mm/dd/yyyy)");
		String birth = input.next();
		do {
			if (!(birth.matches("\\d{2}/\\d{2}/\\d{4}"))) {
				System.out.println("Please enter two digit month, two digit day, and four digit month");
				System.out.println("Enter date of birth (e.g. mm/dd/yyyy)");
				birth = input.next();
			}
		} while (!(birth.matches("\\d{2}/\\d{2}/\\d{4}")));
		
		System.out.println("Enter gender (e.g. male or female)");
		String gender = input.next();
		
		Person person = new Person (birth, first, last, gender);
		System.out.println("Your person was created!");
		
		FilingStuff.writeToFile(PersonList.list);
		startup();
	}

}
