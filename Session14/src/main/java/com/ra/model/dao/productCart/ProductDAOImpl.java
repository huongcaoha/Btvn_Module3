package com.ra.model.dao.productCart;

import com.ra.model.dao.MyInterface;
import com.ra.model.entity.ProductCart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDAOImpl implements MyInterface<ProductCart> {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<ProductCart> getList() {
        List<ProductCart> productCarts = new ArrayList<>();
        try (Session session = sessionFactory.openSession();){
            productCarts =session.createQuery("from ProductCart ", ProductCart.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }

        return productCarts;
    }

    @Override
    public boolean add(ProductCart item) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(item);
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
    public boolean update(ProductCart item) {
        return false;
    }

    @Override
    public boolean delete(ProductCart item) {
        return false;
    }

    @Override
    public ProductCart findById(int id) {
        return null;
    }
}
