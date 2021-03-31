package org.demo.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
        
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Myxml.xml");
		context.registerShutdownHook();
    
    DrawTriangle triangle=(DrawTriangle) context.getBean("triangle1");
		triangle.draw();

		DrawTriangle triangle1=(DrawTriangle) context.getBean("triangle2");
		triangle1.draw();

	}

}
