package com.ra.model.dao.product;

import com.ra.model.dao.ManagementInterface;
import com.ra.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDAO implements ManagementInterface<Product> {
    @Autowired
    private  SessionFactory sessionFactory ;
    @Override
    public List<Product> getList() {
        List<Product> products = new ArrayList<>();
        try (Session session = sessionFactory.openSession()){
           products = session.createQuery("from Product ", Product.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean add(Product object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Product object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Product object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            product = session.get(Product.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return product;
    }

    @Override
    public List<Product> getCateByPage(int page, int size) {
        return null;
    }
}
