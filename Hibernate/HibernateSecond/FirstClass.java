package com.demo.practice.HibrnateSecond;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class FirstClass {
	
	@Id
	@Column(name = "roll_no")
	private int roll;
	
	
	@Transient
	private String firstname;
	
	private Name name;
	
	/*
	 * @OneToOne private Laptop laptop;
	 * 
	 * public Laptop getLaptop() { return laptop; } public void setLaptop(Laptop
	 * laptop) { this.laptop = laptop; }
	 */
	
	
	  @OneToMany (fetch = FetchType.EAGER) private List <Laptop> laptop=new ArrayList <Laptop> ();
	  
	  
	  
	  
	  public List<Laptop> getLaptop() { return laptop; }
	  
	  public void setLaptop(List<Laptop> laptop)
	  
	  { this.laptop = laptop; }
	 
		 
	
	
	
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
		return "FirstClass [roll=" + roll + ", firstname=" + firstname + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	
	
	
	

}
