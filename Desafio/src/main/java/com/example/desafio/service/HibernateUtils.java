package com.example.desafio.service;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtils {
	
	private static final SessionFactory sessionFactory;
	
	static {
		Configuration conf = new Configuration();
		conf.configure();
		
		try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }       
    
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}