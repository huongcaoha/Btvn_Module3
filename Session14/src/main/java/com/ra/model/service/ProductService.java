package com.ra.model.service;

import com.ra.model.dao.MyInterface;
import com.ra.model.dao.product.ProductDAOImpl;
import com.ra.model.entity.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements MyInterface<Product> {
    @Autowired
    private ProductDAOImpl productDAO ;

    public List<Product> getList() {
      return productDAO.getList();
    }


    public boolean add(Product item) {
       return productDAO.add(item);
    }


    public boolean update(Product item) {
       return productDAO.update(item);
    }


    public boolean delete(Product item) {
      return productDAO.delete(item);
    }


    public Product findById(int id) {
       return productDAO.findById(id);
    }
}
