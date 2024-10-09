package com.ra.model.service;

import com.ra.model.dao.ManagementInterface;
import com.ra.model.dao.product.ProductDAO;
import com.ra.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ManagementInterface<Product> {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> getList() {
        return productDAO.getList();
    }

    @Override
    public boolean add(Product object) {
        return productDAO.add(object);
    }

    @Override
    public boolean update(Product object) {
        return productDAO.update(object);
    }

    @Override
    public boolean delete(Product object) {
        return productDAO.delete(object);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }
}
