package com.ra.model.dao.productCart;

import com.ra.model.entity.ProductCart;
import com.ra.model.entity.User;

import java.util.List;

public interface ProductCartDAO {
    List<ProductCart> getCartById(int userId);
    boolean addToCart(int userId , int productId,int quantity );
    boolean deleteProductCart(int user_id,int productId);
    ProductCart findProductCart(int userId , int productId);
    boolean updateCart(int userId , int productId,int quantity);
}
