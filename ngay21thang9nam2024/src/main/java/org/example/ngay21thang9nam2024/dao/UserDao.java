package org.example.ngay21thang9nam2024.dao;

import org.example.ngay21thang9nam2024.entity.User;
import org.example.ngay21thang9nam2024.util.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void register(User user){
        String query = "insert into users(username ,password) values (?,?)";
        try (Connection connection = (Connection) getConnect.getConnection();
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
