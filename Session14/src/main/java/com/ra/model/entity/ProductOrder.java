package com.ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "productOrders")
public class ProductOrder {
    @Id
    @Column(name = "order_id")
    private int order_id ;

    @Column(name = "product_id")
    private int product_id ;

    @Column(name = "quantity")
    private int quantity ;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order ;
    public ProductOrder() {
    }

    public ProductOrder(int order_id, int product_id, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
