package com.ra.model.service;

import com.ra.model.dao.BookDAO;
import com.ra.model.dao.ManagementInterface;
import com.ra.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements ManagementInterface<Book> {
    @Autowired
    private BookDAO bookDAO ;

    @Override
    public List<Book> getList() {
        return bookDAO.getList();
    }

    @Override
    public boolean add(Book object) {
        return bookDAO.add(object);
    }

    @Override
    public boolean update(Book object) {
        return bookDAO.update(object);
    }

    @Override
    public boolean delete(Book object) {
        return bookDAO.delete(object);
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }
}
