package org.demo.practice;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape{
	
	private Point pointO;
    
	
	public Point getPointO() {
		return pointO;
	}


	@Required
	public void setPointO(Point pointO) {
		this.pointO = pointO;
	}


	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Circle point O: ("+pointO.getX() + "," +pointO.getY() +")");
		
	}

	



	

	
	
	

}
