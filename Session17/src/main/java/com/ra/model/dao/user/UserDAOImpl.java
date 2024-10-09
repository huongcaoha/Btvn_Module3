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
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
