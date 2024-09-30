package com.ra.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver" ;
    public static final String URL = "jdbc:mysql://localhost:3307/session10";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345678";

    public static Connection getConnect(){
        Connection connection = null ;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection ;
    }

    public static void main(String[] args) {
        System.out.println(ConnectDB.getConnect());
    }
}
