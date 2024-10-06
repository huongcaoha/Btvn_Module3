package com.ra.model.dao;

import java.util.List;

public interface MyInterface <T>{
     List<T> getList();
     boolean add(T item) ;
     boolean update(T item);
     boolean delete(T item);
     T findById(int id) ;
}
