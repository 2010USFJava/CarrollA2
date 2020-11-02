package com.revature.assignments.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class FilingStuff {
	public static final String personFile = "PersonList.txt";
	
	public static void writeToFile(List<Person> pList) {
		//write to customer file
		try {
			ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(personFile));
			writeFile.writeObject(pList);
			writeFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unchecked")
	public static void readFromFile() {
		//read from customer file
		try {
			ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(personFile));
			PersonList.list = (ArrayList<Person>) readFile.readObject();
			readFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
