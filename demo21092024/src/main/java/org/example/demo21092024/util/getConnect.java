package org.example.demo21092024.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnect {
    public static Connection getConnection(){

        String url = "jdbc:mysql://localhost:3307/ngay21thang9nam2024";
        String username = "root" ;
        String password = "12345678";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url,username,password);
            return  connection ;
        }catch (SQLException e){
            e.printStackTrace();
            return null ;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
