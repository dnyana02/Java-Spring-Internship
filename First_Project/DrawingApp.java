package org.demo.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1: Basic method to implements obeject
		
		/* DrawTriangle dt=new DrawTriangle();
		   dt.draw();
        */
		
		// 2. By using Spring Factory for XML file
		//    For which we need to create our own XML file
		
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("Myxml.xml"));
		DrawTriangle triangle=(DrawTriangle) factory.getBean("triangle");
		triangle.draw();
	}

}
