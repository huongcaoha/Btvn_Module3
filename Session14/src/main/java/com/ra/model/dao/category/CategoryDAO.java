package com.ra.model.dao.category;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getListCategory();
    boolean addCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(Category category);
    Category findById(int id);
}
