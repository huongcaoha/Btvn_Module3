package com.ra.model.entity;

public class Search {
    private double minPrice ;
    private double maxPrice ;
    private String description;
    private int cate_id ;

    public Search() {
        this.description = "";

    }

    public Search( double minPrice, double maxPrice, String description, int cate_id) {

        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.description = description;
        this.cate_id = cate_id;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }
}
