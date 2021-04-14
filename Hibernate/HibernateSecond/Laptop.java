package com.demo.practice.HibrnateSecond;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Laptop {
	
	@Id
	private int lid;
	private String laptop_name;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLaptop_name() {
		return laptop_name;
	}
	public void setLaptop_name(String laptop_name) {
		this.laptop_name = laptop_name;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", laptop_name=" + laptop_name + "]";
	}
	
	
	
	
	 
	
	
	
	
	
	

}
