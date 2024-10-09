package com.ra.model.dao;

import com.ra.model.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookDAO implements ManagementInterface<Book> {
    @Autowired
    private SessionFactory sessionFactory ;
    @Override
    public List<Book> getList() {
        Session session = sessionFactory.openSession();
        try {
           return session.createQuery("from Book ", Book.class).list();
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean add(Book object) {
       Session session = sessionFactory.openSession();
       try {
           session.beginTransaction();
           session.save(object);
           session.getTransaction().commit();
           return true ;
       }catch (Exception e){
           e.printStackTrace();
           session.getTransaction().rollback();
           return false ;
       }finally {
           session.close();
       }
    }

    @Override
    public boolean update(Book object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Book object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close();
        }

    }

    @Override
    public Book findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
           Book book = session.get(Book.class,id);
            session.getTransaction().commit();
            return book;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null ;
        }finally {
            session.close();
        }
    }
}
