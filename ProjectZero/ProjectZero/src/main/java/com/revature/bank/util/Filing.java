package com.revature.bank.util;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.beans.Account;
import com.revature.bank.beans.User;


public class Filing {
	public static final String userFile = "UserList.txt";
	
	public static void writeUserFile(List<User> List) {
		//write to customer file
		try {
			ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(userFile));
			writeFile.writeObject(List);
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static void readUserFile() {
		//read from customer file
		try {
			ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(userFile));
			Verify.userList = (ArrayList<User>) readFile.readObject();
			readFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//add contents of file to separate lists
		for (int i=0; i<Verify.userList.size(); i++) {
			Verify.userIds.add(Verify.userList.get(i).getUserId());
			Verify.usernames.add(Verify.userList.get(i).getUsername());
			if (Verify.userList.get(i).getAccounts() != null) {
				Verify.accountList.addAll(Verify.userList.get(i).getAccounts());
			}
			if (Verify.userList.get(i).getRequests() != null) {
				Verify.requestList.addAll(Verify.userList.get(i).getRequests());	
			}
		}
		for (Account account: Verify.accountList) {
			Verify.accountIds.add(account.getAccountId());
		}
	}
}
