package com.ra.model.entity;

import com.ra.model.service.validator.UserValidator;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname",nullable = false)
    @NotBlank
    private String fullName ;

    @Column(name = "phone",nullable = false , unique = true)
    @NotBlank(message = "phone number cannot blank !")
    @Pattern(regexp = "^0[35789][0-9]{8}$", message = "phone number invalid format ! ")
    @UserValidator(message = "phone exist!")
    private String phone ;

    @Column(name = "email",nullable = false)
    @Email(message = "email not valid format !")
    private String email ;

    @Column(name = "password")
    @Size(min = 6 , max = 255,message = "Password of 6 characters or more !")
    private String password ;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id") ,
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "status")
    @ColumnDefault("true")
    private boolean status;

    @Column(name = "created_date")
    private Date createdDate ;

    public User() {
    }

    public User(int id, String fullName, String phone, String email, String password, Set<Role> roles, boolean status, Date createdDate) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
