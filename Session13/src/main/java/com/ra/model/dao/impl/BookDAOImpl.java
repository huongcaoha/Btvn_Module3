package com.ra.model.dao.impl;

import com.ra.model.dao.BookDAO;
import com.ra.model.dao.database.ConnectDB;
import com.ra.model.entity.Book;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDAOImpl implements BookDAO {
    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnect();
             CallableStatement statement = connection.prepareCall("{call proc_get_book()}");
        ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                book.setDescription(rs.getString("description"));
                books.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean add(Book book) {
        try (Connection connection = ConnectDB.getConnect();
             CallableStatement statement = connection.prepareCall("{call proc_add_book(?,?,?,?)}");
        ){
            statement.setString(1,book.getTitle());
            statement.setString(2,book.getAuthor());
            statement.setDouble(3,book.getPrice());
            statement.setString(4,book.getDescription());
            int rs = statement.executeUpdate();
            if (rs > 0){
                return true ;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public boolean update(Book book) {
        try (Connection connection = ConnectDB.getConnect();
             CallableStatement statement = connection.prepareCall("{call proc_update_book(?,?,?,?,?)}");
        ){
            statement.setInt(1,book.getId());
            statement.setString(2,book.getTitle());
            statement.setString(3,book.getAuthor());
            statement.setDouble(4,book.getPrice());
            statement.setString(5,book.getDescription());
            int rs = statement.executeUpdate();
            if (rs > 0){
                return true ;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = ConnectDB.getConnect();
             CallableStatement statement = connection.prepareCall("{call proc_delete_book(?)}");
        ){
            statement.setInt(1,id);
            int rs = statement.executeUpdate();
            if(rs > 0){
                return true ;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public Book findById(int id) {
        Book book = new Book();
        try (Connection connection = ConnectDB.getConnect();
             CallableStatement statement = connection.prepareCall("{call proc_find_book(?)}");
        ){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDescription(rs.getString("description"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return book ;
    }
}
