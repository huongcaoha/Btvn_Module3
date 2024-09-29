package com.ra.model.service;

import com.ra.dao.GetConnect;
import com.ra.model.entity.IProduct;
import com.ra.model.entity.Product;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductImpl implements IProduct {

    @Override
    public List<Product> getListProduct() {
        List<Product> products = new ArrayList<>();
        String query = "select * from products";
        try (Connection connection = GetConnect.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                String description  = rs.getString("description");
                String image = rs.getString("image");
                Date created_date = rs.getDate("created_date");
                Product product = new Product(id,productName,price,stock,description,image, created_date);
                products.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean addProduct(Product product) {
        String query = "insert into products (productName ,price ,stock ,description ,image)" +
                "values (?,?,?,?,?)";
        try(Connection connection = GetConnect.getConnect() ;
            PreparedStatement preparedStatement = connection.prepareStatement(query) ;
        ) {
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getStock());
            preparedStatement.setString(4,product.getDescription());
            preparedStatement.setString(5,product.getImage());
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false ;
        }
    }


}
