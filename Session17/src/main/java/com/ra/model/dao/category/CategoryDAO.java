package com.ra.model.dao.category;

import com.ra.model.dao.ManagementInterface;
import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDAO implements ManagementInterface<Category> {
    @Autowired
    private SessionFactory sessionFactory ;
    @Override
    public List<Category> getList() {
        List<Category> categories = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            categories = session.createQuery("from Category ", Category.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean add(Category object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Category object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Category object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public Category findById(int id) {
        Session session = sessionFactory.openSession();
        Category category = new Category();
        try {
            session.beginTransaction();
           category = session.get(Category.class,id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return category ;
    }
}
