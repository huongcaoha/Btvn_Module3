package com.ra.model.dao.role;

import com.ra.model.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RoleDAOImpl implements RoleDAO{
    @Autowired
    private SessionFactory sessionFactory ;

    @Override
    public List<Role> getListRole() {
        List<Role> roles = new ArrayList<>( );
        try (Session session = sessionFactory.openSession()){
           roles = session.createQuery("from Role ",Role.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return roles ;
    }

    @Override
    public boolean add(Role role) {
        Session session = sessionFactory.openSession();
       try {
           session.beginTransaction();
           session.save(role);
           session.getTransaction().commit();
           return true ;
       }catch (Exception e){
           session.getTransaction().rollback();
           e.printStackTrace();
           return false;
       }finally {
           session.close();
       }
    }
}
