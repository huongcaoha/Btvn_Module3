package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDAOImpl implements CategoryDAO{
    @Autowired
    private SessionFactory sessionFactory ;
    @Override
    public List<Category> getListCategory() {

        try (Session session = sessionFactory.openSession();){
           return session.createQuery("from Category",Category.class).list();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }


    @Override
    public boolean addCategory(Category category) {
        Session session = sessionFactory.openSession();
       try {
           session.beginTransaction();
            session.save(category) ;
           session.getTransaction().commit();
           return true;
       }catch (Exception e){
           session.getTransaction().rollback();
           e.printStackTrace();
           return false;
       }finally {
           session.close();
       }

    }

    @Override
    public boolean updateCategory(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }
    }

    @Override
    public boolean deleteCategory( Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }
    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction();
            category = session.get(Category.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return category ;
    }
}
