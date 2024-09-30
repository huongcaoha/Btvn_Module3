package com.ra.dao;

import com.ra.database.ConnectDB;
import com.ra.model.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> getListCate() {
        List<Category> categories = new ArrayList<>();
        String query = "select * from category ;";
        try (Connection connection = ConnectDB.getConnect() ;
             PreparedStatement preparedStatement = connection.prepareStatement(query)
            ){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
    }
}
