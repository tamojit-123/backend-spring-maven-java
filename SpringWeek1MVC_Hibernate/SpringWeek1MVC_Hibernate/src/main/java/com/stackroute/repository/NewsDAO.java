package com.stackroute.repository;

import com.stackroute.model.News;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NewsDAO implements INewsDAO{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean addNews(News news) {
       try {
           Session session = sessionFactory.getCurrentSession();
           session.save(news);
           return true;
       }
       catch (HibernateException exception)
       {
           exception.printStackTrace();
           return false;
       }
    }

    @Override
    public List<News> getAllNews() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from News");
        List<News> newsList=query.list();
        return newsList;

       // return sessionFactory.getCurrentSession().createQuery("from News").list();

    }
}
