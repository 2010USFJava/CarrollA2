package com.revature.beans;

public class Student implements Comparable{
	private int studentID;
	private double gpa;
	private String ladel;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentID, double gpa, String label) {
		super();
		this.studentID = studentID;D
		this.gpa= gpa;
		this.ladel = label;
	}
	public int getId() {
		return studentID;
	}
	public void setId(int id) {
		studentID = id;
	}
	public double getGrade() {
		return gpa;
	}
	public void setGrade(double gpa) {
		this.gpa = gpa;
	}
	public String getSomething() {
		return ladel;
	}
	public void setSomething(String something) {
		this.ladel = something;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
