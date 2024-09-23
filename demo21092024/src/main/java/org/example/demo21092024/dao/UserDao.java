package org.example.demo21092024.dao;

import org.example.demo21092024.util.getConnect;
import org.example.demo21092024.entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static void register(User user){
        String query = "insert into users(username ,password) values (?,?)";
        try (Connection connection =  getConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int rs = preparedStatement.executeUpdate();
            if(rs == 0){
                System.err.println("Insert error !");
            }else {
                System.out.println("Insert success !");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
