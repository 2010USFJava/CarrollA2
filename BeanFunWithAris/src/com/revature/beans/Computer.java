package com.revature.beans;

public class Computer {
	String brand;
	String type;
	Mouse mouse;
	int year;
	
	public Computer() {
		
	}
	public Computer(String name, String type, Mouse mouse, int year) {
	
		this.brand = name;
		this.type = type;
		this.mouse = mouse;
		this.year = year;
	}
	public String getName() {
		return brand;
	}
	public void setName(String name) {
		this.brand = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Computer [brand=" + brand + ", type=" + type + ", mouse=" + mouse + ", year=" + year + "]";
	}
	
	
	
	

}
