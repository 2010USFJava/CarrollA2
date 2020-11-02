package com.revature.assignments.bean;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String birthday;
	private String firstName;
	private String lastName;
	private String gender;
	
	public Person() {
		PersonList.list.add(this);
		LogStuff.logThis("info","A new person was created");
	}
	public Person(String birthday, String firstName, String lastName, String gender) {

		this.birthday = birthday;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		PersonList.list.add(this);
		LogStuff.logThis("info","A new person was created");
		
	}
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
		LogStuff.logThis("info", this.firstName + this.lastName + "'s birthdy was updated");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		LogStuff.logThis("info", this.firstName + this.lastName + "'s first name was updated");
	}

	public String getLastName() {
		return lastName;
		
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		LogStuff.logThis("info", this.firstName + this.lastName + "'s last name was updated");
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
		LogStuff.logThis("info", this.firstName + this.lastName + "'s gender was updated");
	}
	@Override
	public String toString() {
		return "Person [birthday=" + birthday + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + "]";
	}
	
	
	

}