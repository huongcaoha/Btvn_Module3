package com.ra.model.dao.product;

import com.ra.model.dao.ManagementInterface;
import com.ra.model.entity.Product;
import com.ra.model.entity.Search;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductDAO implements ManagementInterface<Product> {
    @Autowired
    private  SessionFactory sessionFactory ;
    @Override
    public List<Product> getList() {
        List<Product> products = new ArrayList<>();
        try (Session session = sessionFactory.openSession()){
           products = session.createQuery("from Product ", Product.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean add(Product object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Product object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Product object) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return false ;
        }finally {
            session.close();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            product = session.get(Product.class,id);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return product;
    }

    @Override
    public List<Product> getCateByPage(int page, int size) {
        return null;
    }

    public List<Product> getProductByPage(int page , int size){
        try (Session session = sessionFactory.openSession()){
           return session.createQuery("from Product ",Product.class).setFirstResult((page - 1) * size)
                    .setMaxResults(size).list();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    public List<Product> searchProduct(Search search, int page, int size) {
        StringBuilder hql = new StringBuilder("FROM Product p WHERE 1=1 ");

        // Kiểm tra description không null và không rỗng
        if (search.getDescription() != null && !search.getDescription().isEmpty()) {
            hql.append(" AND (p.name LIKE CONCAT('%', :search, '%') OR p.description LIKE CONCAT('%', :search, '%'))");
        }

        // Kiểm tra giá min
        if (search.getMinPrice() > 0) {
            hql.append(" AND p.price >= :minPrice");
        }

        // Kiểm tra giá max
        if (search.getMaxPrice() > 0 && search.getMaxPrice() > search.getMinPrice()) {
            hql.append(" AND p.price <= :maxPrice");
        }

        // Kiểm tra cate_id
        if (search.getCate_id() > 0) {
            hql.append(" AND p.category.id = :cate_id"); // Sử dụng category.id
        }

        try (Session session = sessionFactory.openSession()) {
            Query<Product> query = session.createQuery(hql.toString(), Product.class);

            // Thiết lập tham số cho description
            if (search.getDescription() != null && !search.getDescription().isEmpty()) {
                query.setParameter("search", search.getDescription());
            }
            // Thiết lập tham số cho minPrice
            if (search.getMinPrice() > 0) {
                query.setParameter("minPrice", search.getMinPrice());
            }
            // Thiết lập tham số cho maxPrice
            if (search.getMaxPrice() > 0 && search.getMaxPrice() > search.getMinPrice()) {
                query.setParameter("maxPrice", search.getMaxPrice());
            }
            // Thiết lập tham số cho cate_id
            if (search.getCate_id() > 0) {
                query.setParameter("cate_id", search.getCate_id());
            }

            return query.setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();

        } catch (Exception e) {
            e.printStackTrace(); // In lỗi ra console
        }

        return new ArrayList<>(); // Đảm bảo luôn trả về danh sách
    }

    public boolean checkSearchNull(Search search){
        return search.getCate_id() <= 0 && search.getMinPrice() <= 0 &&
                search.getMaxPrice() <= 0 && Objects.equals(search.getDescription(), "");
    }
}
