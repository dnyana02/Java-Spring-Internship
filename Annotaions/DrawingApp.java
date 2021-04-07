package org.demo.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
        
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Myxml.xml");
		context.registerShutdownHook();
		
		Shape circle=(Shape) context.getBean("circle");
		circle.draw();
		
		
	}

}

