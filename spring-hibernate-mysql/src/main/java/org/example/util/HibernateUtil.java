package org.example.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            // creating the object of configuration
            Configuration configuration = new Configuration();

            //configure() loads your hibernate.cfg.xml file
            configuration.configure("hibernate.cfg.xml");

            configuration.addResource("user.hbm.xml");
            // from hibernate 4 onwards we need to use ServiceRegistry to load to hibernate properties
            ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            // creating the object of session-factory
            sessionFactory = configuration.buildSessionFactory(sr);
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }
        return sessionFactory;
    }
}
