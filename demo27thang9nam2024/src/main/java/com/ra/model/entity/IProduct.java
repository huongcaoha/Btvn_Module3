package com.ra.model.entity;

import java.util.List;

public interface IProduct {
    public List<Product> getListProduct();
    public boolean addProduct(Product product);
}
