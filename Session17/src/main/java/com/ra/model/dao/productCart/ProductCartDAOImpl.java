package com.ra.model.dao.productCart;

import com.ra.model.entity.Product;
import com.ra.model.entity.ProductCart;
import com.ra.model.entity.User;
import com.ra.model.service.product.ProductService;
import com.ra.model.service.user.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCartDAOImpl implements ProductCartDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Override
    public List<ProductCart> getCartById(int userId) {
        List<ProductCart> productCarts = new ArrayList<>();
        try (Session session = sessionFactory.openSession()){
          productCarts =  session.createQuery("from ProductCart pc where pc.user.id = :_userId", ProductCart.class)
                    .setParameter("_userId",userId).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return productCarts ;
    }

    @Override
    public boolean addToCart(int userId, int productId, int quantity) {
        Session session = sessionFactory.openSession();
        Product product = productService.findById(productId);
        User user = userService.findById(userId);
        ProductCart productCart = new ProductCart();
        productCart.setProduct(product);
        productCart.setUser(user);
        productCart.setQuantity(quantity);
        try {
            session.beginTransaction();
            session.save(productCart);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }
    }

    @Override
    public boolean deleteProductCart(int user_id, int productId) {
        Session session = sessionFactory.openSession();
        ProductCart productCart = findProductCart(user_id,productId);
        try {
            session.beginTransaction();
            session.delete(productCart);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }
    }

    @Override
    public ProductCart findProductCart(int userId, int productId) {

        try (Session session = sessionFactory.openSession()){
           return session.createQuery("from ProductCart pc where pc.user.id = :_userId and pc.product.id = :_productId", ProductCart.class)
                    .setParameter("_userId",userId).setParameter("_productId",productId).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
       return null ;
    }

    @Override
    public boolean updateCart(int userId, int productId, int quantity) {
        Session session = sessionFactory.openSession();
        ProductCart productCart = findProductCart(userId,productId);
        productCart.setQuantity(quantity);
        try {
            session.beginTransaction();
            session.update(productCart);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }
    }

}
