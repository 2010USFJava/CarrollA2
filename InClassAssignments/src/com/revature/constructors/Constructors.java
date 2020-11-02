package com.revature.constructors;

public class Constructors {
	
	

	//public Constructors(int i, int j) {
	//	System.out.println("primitive int");
	//}
	public Constructors(int i, double j) {
		System.out.println("primitive double");
	}
	//public Constructors(int i, Integer i) {
	//	System.out.println("int wrapper");
	//}
	public Constructors(int ... i) {
		System.out.println("Vararg");
	}

	public static void main(String[] args) {
		
		//Constructors num1 = new Constructors(5.0);
		//Constructors num2 = new Constructors(5,5);
		Constructors num3 = new Constructors(5, new Integer(5));
	}

}
