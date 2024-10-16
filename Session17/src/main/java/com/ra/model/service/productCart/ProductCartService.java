package com.ra.model.service.productCart;

import com.ra.model.entity.ProductCart;

import java.util.List;

public interface ProductCartService {
    List<ProductCart> getCartById(int userId);
    boolean addToCart(int userId , int productId,int quantity );
    boolean deleteProductCart(int user_id,int productId);
    ProductCart findProductCart(int userId , int productId);
    boolean updateCart(int userId , int productId,int quantity);
}
