package com.ra.base_spring_mvc.model.service.product;

import com.ra.base_spring_mvc.model.dao.product.ProductDAO;
import com.ra.base_spring_mvc.model.entity.Product;
import com.ra.base_spring_mvc.model.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private FileService fileService;

    @Override
    public List<Product> findAll(int page, int size) {
        return productDAO.findAll(page,size);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public double totalPages(int size) {
        return Math.ceil((double) productDAO.totalElement() / size);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> searchProduct(String productName,int page, int size) {
        return productDAO.searchProduct(productName,page,size);
    }

    @Override
    public boolean createProduct(Product product) {
        return productDAO.createProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
    productDAO.deleteProduct(id);
    }
}
