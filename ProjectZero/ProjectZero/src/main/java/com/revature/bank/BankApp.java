package com.revature.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BankApp {
	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) {
		Employee admin = new Employee(12345,"theAdmin","p4ssword");
		Employee employee = new Employee(21234,"regEmployee","password");


		String menuChoice;
		int index;
		
		do {
			System.out.println("Enter '1' to log-in or '2' to register.");
			menuChoice = input.next();
			//user login
			if (menuChoice.equals("1")) {
				index = Menus.login();
				if (String.valueOf(User.userIds.get(index)).startsWith("1")) {
					System.out.println("yes");
				}else if (String.valueOf(User.userIds.get(index)).startsWith("2")) {
					
				}else {
					
				}
				break;
			}
			//customer registration
			if (menuChoice.equals("2")) {
				Menus.register();
				System.out.println("To apply for checking account");
				break;
			}
		}while (menuChoice != "1" || menuChoice != "2");
		

		
	}

}
