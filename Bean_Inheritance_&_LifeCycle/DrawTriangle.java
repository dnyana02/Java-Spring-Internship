package org.demo.practice;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DrawTriangle implements ApplicationContextAware, BeanNameAware /* ,InitializingBean,DisposableBean */ {
	
	
	 
	  private Point pointA;
	  private Point pointB; 
	  private Point pointC;
	  private ApplicationContext context=null;
	  
	  
	 
     
	public Point getPointA() { return pointA; }
	  
	  public void setPointA(Point pointA) { this.pointA = pointA; }
	  
	  public Point getPointB() { return pointB; }
	  
	  public void setPointB(Point pointB) { this.pointB = pointB; }
	  
	  public Point getPointC() { return pointC; }
	  
	  public void setPointC(Point pointC) { this.pointC = pointC; }
	  
	  
	  public void draw() { 
		  try {
			    System.out.println("Point A= ("+getPointA().getX() + ","+getPointA().getY() +")"); 
				System.out.println("Point B= ("+getPointB().getX()+ "," +getPointB().getY() +")");
				System.out.println("Point C= ("+getPointC().getX() + "," +getPointC().getY()+")");		
		      } 
		  
		 catch (Exception e) {
		
		
		}
		  
		 
	
	 
	
	
	
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
	
		this.context=context;
	}

	@Override
	public void setBeanName(String beanName) {
		
		System.out.println("Bean Name is "+beanName);
	}

	

	
	/*
	 * @Override public void afterPropertiesSet() throws Exception {
	 * 
	 * System.out.println("InitializingBean Method"); }
	 * 
	 * @Override public void destroy() throws Exception {
	 * 
	 * System.out.println("Distroy Method to dispose Bean");
	 * 
	 * }
	 */
	
	
	  public void myInit() throws Exception {
	  System.out.println("My InitializingBean Method"); }
	  
	  public void myDestroy() throws Exception {
	  System.out.println("My Destroy Method"); }
	 
	
     
	
		
		 
		  
		  
		 
}
