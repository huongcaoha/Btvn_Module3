package org.example.ngay21thang9nam2024.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnect {
    public static getConnect getConnection(){
        java.sql.Connection connection = null;
        String url = "jdbc:mysql://localhost:3307/ngay21thang9nam2024";
        String username = "root" ;
        String password = "12345678";
        try {
            connection = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return (getConnect) connection;
    }
}
