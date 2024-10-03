package com.ra.model.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnect(){
        String url = "jdbc:mysql://localhost:3307/session13";
        String username = "root" ;
        String password = "12345678" ;
        Connection connection = null ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection ;
    }


}
