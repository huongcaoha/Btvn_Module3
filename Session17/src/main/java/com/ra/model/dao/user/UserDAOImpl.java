package com.ra.model.dao.user;

import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.model.entity.constant.RoleEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory ;
    @Override
    public List<User> getList(int page , int itemPerPage) {
        try (Session session = sessionFactory.openSession()){
           return session.createQuery("from User",User.class).setFirstResult((page-1) * itemPerPage).setMaxResults(itemPerPage).list();
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }

    @Override
    public boolean add(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(findRoleByName(RoleEnum.USER));
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
        user.setRoles(roles);
        user.setEmail("");
        user.setStatus(true);
        user.setCreatedDate(new Date());
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

    @Override
    public Role findRoleByName(RoleEnum roleEnum) {
        try (Session session = sessionFactory.openSession();){
           return session.createQuery("from Role as r where r.roleName = :_roleName",Role.class)
                    .setParameter("_roleName",roleEnum).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

}
