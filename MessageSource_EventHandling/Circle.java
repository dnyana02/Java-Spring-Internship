package org.demo.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Circle implements Shape,ApplicationEventPublisherAware{
	
	private Point pointO;
	@Autowired
	private MessageSource messageSource;
    private ApplicationEventPublisher publisher;
	
	public Point getPointO() {
		return pointO;
	}


    @Resource
	public void setPointO(Point pointO) {
		this.pointO = pointO;
	}
	
	
	



  

	public MessageSource getMessageSource() {
		return messageSource;
	}



	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}



	@Override
	public void draw() {
	  
	  System.out.println(this.messageSource.getMessage("greeting",null ,"Default Greet" , null));
	  System.out.println(this.messageSource.getMessage("circle.drawing",null ,"Default Drawing" , null));
	  System.out.println(this.messageSource.getMessage("circle.point",new Object[] {pointO.getX(),pointO.getY()} ,"Default Centre" , null));
	  MyOwnEventHandler drawEvent=new MyOwnEventHandler(this);
	  publisher.publishEvent(drawEvent);
	}

	@PostConstruct
	public void Myinit()
	{
		System.out.println("Initialization of Bean");
	}

	@PreDestroy
	public void Mydestroy()
	{
		System.out.println("Destroy of Bean");
	}


	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
		
	}

	

	
	
	

}
