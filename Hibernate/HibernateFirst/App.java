package com.demo.practice.HiberanateDemo;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args ) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
    	Name name=new Name();
    	
    	name.setFname("XYZ");
    	name.setLname("abc");
    	name.setMidname("pqr");
    	
        FirstClass fc=new FirstClass();
        fc.setRoll(1);
        fc.setName(name);
        fc.setMarks(95);
        
        Configuration con=new Configuration().configure().addAnnotatedClass(FirstClass.class);
        
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();            
        
        
        
        SessionFactory sf=con.buildSessionFactory(reg);
        
        Session session=sf.openSession();
        
        org.hibernate.Transaction tx=session.beginTransaction();
        session.save(fc);
        
        fc=(FirstClass) session.get(FirstClass.class, 1);
        
        
        
        tx.commit();
        System.out.println(fc);
        
        
    }
}
