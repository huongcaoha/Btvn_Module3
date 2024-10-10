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
    public List<User> getList(int page , int itemPerPage) {
        return userDAO.getList(page,itemPerPage);
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
       long count = 0 ;
        try (Session session = sessionFactory.openSession()){
           count = session.createQuery("select count(u) from User u where u .phone = :phone",Long.class)
                   .setParameter("phone",phone)
                   .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (count == 0){
            return false ;
        }else {
            return true ;
        }
    }

    @Override
    public double getTotalPage(int itemPerPage, int page) {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()){
           users = session.createQuery("from User ",User.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  Math.ceil((double) users.size() / itemPerPage) ;
    }

    @Override
    public List<User> searchListByNameOrPhone(List<User> users , String search) {
       return  users.stream().filter(user -> user.getPhone().contains(search) || user.getFullName().contains(search)).toList();
    }


}
