package com.demo.practice.HibrnateSecond;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args ) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
    	Laptop laptop=new Laptop();
    	laptop.setLid(2);
    	laptop.setLaptop_name("MacBook");
    	
    	Name name=new Name();
    	
    	name.setFname("Abc");
    	name.setLname("Xyz");
    	name.setMidname("Mno");
    	
        FirstClass fc=new FirstClass();
        fc.setRoll(1);
        fc.setName(name);
        fc.setMarks(95);
        /*fc.getLaptop(laptop); //OneToOne */
        fc.getLaptop().add(laptop); // Many To One
       
        
        Configuration con=new Configuration().configure().addAnnotatedClass(FirstClass.class).addAnnotatedClass(Laptop.class);
        
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();            
        
        
        
        SessionFactory sf=con.buildSessionFactory(reg);
        
        Session session=sf.openSession();
        
        session.beginTransaction();
		
		    session.save(fc); 
        session.save(laptop);
		 
        System.out.println("================================================");
        
        fc=(FirstClass) session.get(FirstClass.class, 1);
        System.out.println(fc);
        
        //First Level OF cache is used for same session
        fc=(FirstClass) session.get(FirstClass.class, 1);
        System.out.println(fc);
        
        System.out.println("================================================");
       
        
        System.out.println("Cache using Hibernate Query");
        Query q1=session.createQuery("from FirstClass where roll_no=1");
        q1.setCacheable(true);
        fc=(FirstClass) q1.uniqueResult();
        System.out.println(fc);
        
        
        System.out.println("================================================");
        
       
        
        
        
        laptop=(Laptop) session.get(Laptop.class, 1);
        
        
        session.getTransaction().commit();
        session.close();
        System.out.println(laptop);
        
        //After new session it will create new first level of cache
        Session session1=sf.openSession();
        
        session1.beginTransaction();
        
        System.out.println("================================================");
        
        fc=(FirstClass) session1.get(FirstClass.class, 1);
        System.out.println(fc);
        
        System.out.println("================================================");
        
        System.out.println("Cache using Hibernate Query");
        Query q2=session1.createQuery("from FirstClass where roll_no=1");
        q2.setCacheable(true);
        fc=(FirstClass) q2.uniqueResult();
        System.out.println(fc);
        
        System.out.println("================================================");
        
        session1.getTransaction().commit();
        session1.close();
        
    }
}
