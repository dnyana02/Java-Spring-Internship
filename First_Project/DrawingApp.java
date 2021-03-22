package org.demo.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("Myxml.xml"));
		DrawTriangle triangle=(DrawTriangle) factory.getBean("triangle");
		triangle.draw();
	}

}
