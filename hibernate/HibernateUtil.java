package com.stackroute.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

// configuration  --> SessionFactory
public class HibernateUtil {


    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        try {
            // creating the object of configuration
            Configuration configuration = new Configuration();
            //configure() loads your hibernate.cfg.xml file
            configuration.configure("hibernate.cfg.xml");
            configuration.addResource("user.hbm.xml");
            // from hibernate 4 onwards we need to use ServiceRegistry to load the hibernate properties
            ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            // creating the object of sessionfactory
            sessionFactory = configuration.buildSessionFactory(sr);
        }
        catch (HibernateException exception){
            exception.printStackTrace();        }
       return sessionFactory;
    }
}
