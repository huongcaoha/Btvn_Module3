package com.ra.model.dao;

import com.ra.model.entity.Category;

import java.util.List;

public interface ManagementInterface<T>{
    List<T> getList();
    boolean add(T object);
    boolean update(T object);
    boolean delete(T object);
    T findById(int id);
    List<T> getCateByPage(int page , int size);
}
