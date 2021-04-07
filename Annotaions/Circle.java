package org.demo.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
	
	private Point pointO;
    
	
	public Point getPointO() {
		return pointO;
	}


//	@Required
	/*
	 * @Autowired
	 * 
	 * @Qualifier("circleClass")
	 */
	@Resource(name="pointC")
	public void setPointO(Point pointO) {
		this.pointO = pointO;
	}


	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Circle point O: ("+pointO.getX() + "," +pointO.getY() +")");
		
	}

	@PostConstruct
	public void Myinit()
	{
		System.out.println("Initialization of Bean");
	}

	@PreDestroy
	public void Mydestroy()
	{
		System.out.println("Destroy of Bean");
	}

	

	
	
	

}
