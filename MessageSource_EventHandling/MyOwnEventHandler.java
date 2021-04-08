package org.demo.practice;

import org.springframework.context.ApplicationEvent;

public class MyOwnEventHandler extends ApplicationEvent{

	public MyOwnEventHandler(Object source) {
		super(source);
		
	}
     
	public String toString()
	{
		return "Draw Event Occured";
	}
}
