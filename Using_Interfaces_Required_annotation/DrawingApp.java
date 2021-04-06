package org.demo.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
        
		ApplicationContext context=new ClassPathXmlApplicationContext("Myxml.xml");
		
		Shape triangle=(Shape) context.getBean("triangle");
		triangle.draw();
		
		
		Shape circle=(Shape) context.getBean("circle");
		circle.draw();
		
		
	}

}
