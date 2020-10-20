package com.revature.beans;

public class Mouse {
	String type;
	String size;
	String brand;
	
	public Mouse() {
		
	}
	public Mouse(String type, String size, String brand) {
		this.type = type;
		this.size = size;
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Mouse [type=" + type + ", size=" + size + ", brand=" + brand + "]";
	}
	
	

}
