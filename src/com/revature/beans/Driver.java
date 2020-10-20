package com.revature.beans;

public class Driver {

	public static void main(String[] args) {
		Mouse mouse1 = new Mouse("Wired","medium","Logitech");
		Computer computer1 = new Computer ("HP","Laptop",mouse1,2020);
		Computer computer2 = new Computer("Dell","Desktop",new Mouse("Wireless","small","Dell"),2019);
		
		System.out.println(mouse1);
		System.out.println(computer1);
		System.out.println(computer2);
		
		

	}

}
