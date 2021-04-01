package org.demo.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("After Initialization of Processor.Bean Name: " +beanName);
		System.out.println("=======================================================");
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("=======================================================");
		System.out.println("Before Initialization of Processor.Bean Name: " +beanName);
		
		return bean; 
	}

}
