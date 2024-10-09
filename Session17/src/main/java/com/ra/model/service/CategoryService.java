package com.ra.model.service;

import com.ra.model.dao.ManagementInterface;
import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ManagementInterface<Category> {
    @Autowired
    private CategoryDAO categoryDAO ;
    @Override
    public List<Category> getList() {
        return categoryDAO.getList();
    }

    @Override
    public boolean add(Category object) {
        return categoryDAO.add(object);
    }

    @Override
    public boolean update(Category object) {
        return categoryDAO.update(object);
    }

    @Override
    public boolean delete(Category object) {
        return categoryDAO.delete(object);
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }
}
