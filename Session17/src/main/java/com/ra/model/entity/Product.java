package com.ra.model.entity;

import com.ra.model.service.validator.product.ProductUnique;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "name",nullable = false)
    @NotNull(message = "product name not null !")
    @Size(min = 5 , max = 100 , message = "length name from 5 to 100 character !")
    @ProductUnique
    private String name ;

    @Column(name = "price",nullable = false)
    @Min(value = 1 , message = "price  > 0 !")
    private double price ;

    @Column(name = "description")
    private String description ;

    @Column(name = "status")
    @ColumnDefault("1")
    private int status ;

    @Column(name = "image")
    @NotNull(message = "image do not blank !")
    private String image ;

    @ManyToOne()
    @JoinColumn(name = "cateId",referencedColumnName = "id")
    private Category category ;

    public Product() {
    }

    public Product(int id, String name, double price, String description, int status, String image, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
