package com.ra.model.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "name" , length = 100 ,unique = true)
    @NotNull
    @Size(min = 5 , max = 100 , message = "name include 5 to 100 character !")
    private String name ;

    @Column(name = "description")
    private String description ;

    @Column(name = "status" )
    @ColumnDefault("1")
    private boolean status ;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private Set<Product> products;

    public Category() {
    }

    public Category(int id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
