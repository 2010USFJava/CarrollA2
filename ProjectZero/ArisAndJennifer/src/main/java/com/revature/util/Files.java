package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Accounts;

public class Files {
	public static final String accountFile = "Account.txt";
	
	@SuppressWarnings("unchecked")
	public static void readFile() {
		try {
			ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(accountFile));
			AccountList.accountList = (ArrayList<Accounts>) readFile.readObject();
			readFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void writeFile(List<Accounts> List) {
		try {
			ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(accountFile));
			writeFile.writeObject(List);
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
