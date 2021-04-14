package com.demo.practice.HQLquery;

import java.util.List;
import java.util.Map;
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
    	
         
         
         Configuration con=new Configuration().configure().addAnnotatedClass(FirstClass.class);
         ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();            
         SessionFactory sf=con.buildSessionFactory(reg);         
         Session session=sf.openSession();         
         session.beginTransaction();
         
			/*
			 * Random r=new Random(); for(int i=1;i<=15;i++) { FirstClass fc=new
			 * FirstClass(); fc.setRoll(i); fc.setFirstname("Student"+i);
			 * fc.setMarks(r.nextInt(100)); session.save(fc); }
			 */
         
         Query q=session.createQuery("from demo_class where marks>50"); // select query
         List <FirstClass> fc=q.list();
         
         for(FirstClass f :fc)
         {
        	 System.out.println(f);
         }
 		 int mark=50;
         q=session.createQuery("select sum(marks) from demo_class d where d.marks>= :mark"); // select query
         q.setParameter("mark", mark);
         Long  f= (Long ) q.uniqueResult();
         System.out.println(f);
         
         
         //Native Query
         
         SQLQuery query=session.createSQLQuery("select roll,firstname from demo_class");
         query.setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP);
         List student=query.list();
         
         for(Object o:student)
         {
        	 Map m=(Map)o;
        	 System.out.println(m.get("roll") +":"+ m.get("firstname"));
         }
         
         
         
 		 session.getTransaction().commit();
         session.close();
         
    }
}
