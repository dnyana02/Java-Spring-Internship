package com.demo.practice.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class App 
{
    public static void main( String[] args )
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("name");
       EntityManager em=emf.createEntityManager();
       
       Laptop l=em.find(Laptop.class, 4);
    }
}
