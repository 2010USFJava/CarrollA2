package com.revature.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Filing {
	public static void readFromFile(User customer) {
		//write to customer file
		try {
			ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("test.txt"));
			writeFile.writeObject(customer);
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void writeToFile() {
		//read from customer file
		try {
			ObjectInputStream readObject = new ObjectInputStream(new FileInputStream("test.txt"));
			System.out.println(readObject.readObject());
			readObject.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
