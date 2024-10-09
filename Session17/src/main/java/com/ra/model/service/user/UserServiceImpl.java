package com.ra.model.service.user;

import com.ra.model.dao.user.UserDAO;
import com.ra.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO ;
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    public boolean add(User user) {
        return userDAO.add(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean delete(User user) {
        return userDAO.delete(user);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public User checkUserExist(String phone,String password) {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession();){
           users = session.createQuery("from User u where u.phone = :phone",User.class).setParameter("phone",phone).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(users.isEmpty()){
           return null ;
        }else {
            User user = users.getFirst();
            if (user.getPassword().equals(password)){
                return user;
            }else {
                return null ;
            }
        }

    }

    @Override
    public boolean checkPhoneExist(String phone) {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()){
           users = session.createQuery(" from User where User .phone = :phone",User.class).setParameter("phone",phone).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(users.isEmpty()){
            return false;
        }else {
            return true ;
        }
    }
}
