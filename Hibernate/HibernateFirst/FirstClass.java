package com.demo.practice.HiberanateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "firstclass")
public class FirstClass {
	
	@Id
	@Column(name = "roll_no")
	private int roll;
	
	
	@Transient
	private String firstname;
	
	private Name name;
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	private int marks;
	
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "FirstClass [roll=" + roll + ", firstname=" + firstname + ", marks=" + marks + "]";
	}
	
	
	

}
