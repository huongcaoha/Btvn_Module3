package com.ra.base_spring_mvc.model.service.product;

import com.ra.base_spring_mvc.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll(int page, int size);

    List<Product> findAll();

    List<Product> searchProduct(String productName,int page, int size);

    double totalPages(int size);

    Product findById(int id);

    boolean createProduct(Product product);

    boolean updateProduct(Product product);

    void deleteProduct(int id);
}
