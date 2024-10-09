package com.ra.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "name")
    private String name ;

    @Column(name = "price")
    private double price ;

    @Column(name = "image")
    private String image ;

    @Column(name = "status")
    private int status ;

    @Column(name = "created_date")
    private Date created_date ;

    @ManyToOne
    @JoinColumn(name = "cate_id" , referencedColumnName = "id")
    private Category category ;

    public Book() {
    }

    public Book(int id, String name, double price, String image, int status, Date created_date, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.status = status;
        this.created_date = created_date;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
