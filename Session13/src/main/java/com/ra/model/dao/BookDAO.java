package com.ra.model.dao;

import com.ra.model.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAll();
    boolean add(Book book);
    boolean update(Book book);
    boolean delete(int id) ;
    Book findById(int id);
}
