package com.stackroute.dao;

import com.stackroute.model.User;
import com.stackroute.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl {

public boolean saveUser(User user){
   try {
       // getting the object of SessionFactory from HibernateUtil class
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       // creating the object of Session to establish a physical connection
       Session session = sessionFactory.openSession();
       Transaction transaction = session.beginTransaction();
       session.save(user);
       transaction.commit();
   }
   catch (HibernateException exception)
   {
       exception.printStackTrace();
   }
   return true;
}


public List<User> getAllUsers()
{
    List<User> userList=null;
    try {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("from User");
        userList = query.list();
        transaction.commit();
    }
    catch (HibernateException exception){
        exception.printStackTrace();
    }
    return userList;
}
}
