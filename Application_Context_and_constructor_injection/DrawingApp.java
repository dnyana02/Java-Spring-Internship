package org.demo.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
   
    ApplicationContext context=new ClassPathXmlApplicationContext("Myxml.xml");
		DrawTriangle triangle=(DrawTriangle) context.getBean("triangle");
		triangle.draw();
		
	}

}
