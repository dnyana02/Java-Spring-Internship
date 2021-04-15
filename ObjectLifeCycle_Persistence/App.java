package com.demo.practice.ObjectPersistant;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import net.sf.ehcache.search.expression.Criteria;



public class App 
{
    public static void main( String[] args )
    {
    	
         
         
         Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class);
         ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();            
         SessionFactory sf=con.buildSessionFactory(reg);         
         Session session=sf.openSession();         
         session.beginTransaction();
			
			  Random r=new Random(); for(int i=1;i<20;i++) { Laptop lap=new Laptop();
			  lap.setLid(i); lap.setBrand("Brand_"+i); lap.setPrice(r.nextInt(65000));
			  session.save(lap); }
			 
         
         
         Laptop l=new Laptop();
         l.setLid(23);
         l.setBrand("DELL");
         l.setPrice(62000);
         session.save(l);
         
         //session.detach(l);
        // session.remove(l);
 		 session.getTransaction().commit();
 		
 		 l.setPrice(58000);
 		 
 		 l=(Laptop) session.get(Laptop.class, 10); //Get:give actual object
 		 System.out.println(l);
 		 
 		 l=(Laptop) session.load(Laptop.class, 10);//load:give proxy object
 		 System.out.println(l);
         session.close();
        
         
    }
}
