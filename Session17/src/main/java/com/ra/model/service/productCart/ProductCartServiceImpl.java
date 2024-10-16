package com.ra.model.service.productCart;

import com.ra.model.dao.productCart.ProductCartDAO;
import com.ra.model.entity.ProductCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCartServiceImpl implements ProductCartService{
    @Autowired
    private ProductCartDAO productCartDAO;
    @Override
    public List<ProductCart> getCartById(int userId) {
        return productCartDAO.getCartById(userId);
    }

    @Override
    public boolean addToCart(int userId, int productId, int quantity) {
        return productCartDAO.addToCart(userId,productId,quantity);
    }

    @Override
    public boolean deleteProductCart(int user_id, int productId) {
        return productCartDAO.deleteProductCart(user_id,productId);
    }

    @Override
    public ProductCart findProductCart(int userId, int productId) {
        return productCartDAO.findProductCart(userId, productId);
    }

    @Override
    public boolean updateCart(int userId, int productId, int quantity) {
        return productCartDAO.updateCart(userId,productId,quantity);
    }
}
