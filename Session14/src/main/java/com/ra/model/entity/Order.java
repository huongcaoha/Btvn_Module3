package com.ra.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "customerName")
    private String customerName ;

    @Column(name = "address")
    private String address ;

    @Column(name = "phone")
    private String phone ;

    @Column(name = "status")
    private int status ;

    @Column(name = "quantity")
    private int quantity ;

    @Column(name = "totalMoney")
    private Double totalMoney ;

    @Column(name = "created_date")
    private Date created_date = new Date() ;

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private Set<ProductOrder> productOrders ;


    public Order() {
        created_date = new Date();
    }

    public Order( String customerName, String address, String phone, int status, int quantity, Double totalMoney) {
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.quantity = quantity;
        this.totalMoney = totalMoney;
        this.created_date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
