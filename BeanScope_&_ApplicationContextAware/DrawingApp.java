package org.demo.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
        
		ApplicationContext context=new ClassPathXmlApplicationContext("Myxml.xml");
		DrawTriangle triangle=(DrawTriangle) context.getBean("triangle");
		System.out.println("First obj. hashcode : "+triangle.hashCode());
		triangle.draw();
		
		DrawTriangle triangle1=(DrawTriangle) context.getBean("triangle");
		System.out.println("Second obj. hashcode : "+triangle1.hashCode());
		triangle1.draw();
	}

}
