package org.example.ngay22thang9nam2024.dao;

import org.example.ngay22thang9nam2024.entity.User;
import org.example.ngay22thang9nam2024.util.GetConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public static void addUSer(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        String query = "insert into Users(username ,password) values (?,?);";
        try (Connection connection = GetConnect.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
           int rs = preparedStatement.executeUpdate();
           if(rs > 0){
               System.out.println("Insert success !");
           }else {
               System.err.println("Insert error !");
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
