package com.ra.demo.service;

import com.ra.demo.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductInterfaceIpl implements IProduct {
    @Override
    public List<Product> getListProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Bim Bim",5000,99,"made in vietnam"));
        products.add(new Product(2,"Kẹo Mút",1000,99,"made in China"));
        products.add(new Product(3,"Mỳ Gói",4000,99,"made in vietnam"));
        products.add(new Product(4,"Sách",10000,50,"made in vietnam"));
        products.add(new Product(5,"Bút Chì",14000,99,"made in Paris"));
        products.add(new Product(6,"Bút Màu",50000,99,"made in vietnam"));
        products.add(new Product(7,"Kem Đánh Răng",35000,99,"made in vietnam"));
        return products;

    }
}
