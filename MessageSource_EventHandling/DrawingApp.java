package org.demo.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
        
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Myxml.xml");
		context.registerShutdownHook();
		
		
		System.out.println(context.getMessage("greet", null,"Default Greeting",null));
		Shape circle=(Shape) context.getBean("circle");
		circle.draw();
		
		
		
		
		
	}

}
