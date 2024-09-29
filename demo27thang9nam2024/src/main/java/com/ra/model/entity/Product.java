package com.ra.model.entity;

import java.sql.Date;

public class Product {
    private int id ;
    private String productName ;
    private double price ;
    private int stock ;
    private String description ;
    private String image ;
    private Date created_date ;

    public Product() {
    }

    public Product(int id, String productName, double price, int stock, String description, String image, Date created_date) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.image = image;
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", created_date=" + created_date +
                '}';
    }
}
