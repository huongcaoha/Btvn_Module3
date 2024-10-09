package com.ra.model.dao.user;

import com.ra.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory ;
    @Override
    public List<User> getList() {
        try (Session session = sessionFactory.openSession()){
           return session.createQuery("from User ",User.class).list();
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }

    @Override
    public boolean add(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public User findById(int id) {
        User user = new User();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
           user = session.get(User.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user ;
    }

}
