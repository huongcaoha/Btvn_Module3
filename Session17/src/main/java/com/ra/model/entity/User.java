package com.ra.model.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname",nullable = false)
    private String fullName ;

    @Column(name = "phone",nullable = false , unique = true)
    private String phone ;

    @Column(name = "email",nullable = false,unique = true)
    private String email ;

    @Column(name = "role")
    @ColumnDefault("1")
    private int role ;

    @Column(name = "status")
    @ColumnDefault("true")
    private boolean status;

    @Column(name = "created_date")
    private Date createdDate ;

    public User() {
    }

    public User(int id, String fullName, String phone, String email, int role, boolean status, Date createdDate) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.status = status;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
