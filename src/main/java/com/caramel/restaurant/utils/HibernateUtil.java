package com.caramel.restaurant.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
//    public HibernateUtil(){
//    	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(
//    			configuration.getProperties());
//    	
//    	sessionFactory = configuration.buildSessionFactory(builder.build());
//    }
}
