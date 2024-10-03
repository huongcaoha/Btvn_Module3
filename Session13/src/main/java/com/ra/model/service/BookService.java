package com.ra.model.service;

import com.ra.model.dao.impl.BookDAOImpl;
import com.ra.model.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
   private static final BookDAOImpl bookDAO = new BookDAOImpl();
   public static List<Book> getAll(){
       return bookDAO.getAll();
   };
   public static boolean add(Book book){
       return bookDAO.add(book);
   };
   public static boolean update(Book book){
       return bookDAO.update(book);
   };
   public static boolean delete(int id){
        return bookDAO.delete(id);
    } ;
   public static Book findById(int id){
       return bookDAO.findById(id);
   };
}
