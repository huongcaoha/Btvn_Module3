package com.ra.model.service.category;

import com.ra.model.entity.Category;
import com.ra.model.entity.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<Category> getList();
    boolean add(CategoryDTO categoryDTO);
    boolean update(Category category);
    boolean delete(Category category);
    Category findById(int id);
    CategoryDTO converseCategory(Category category);
    List<Category> getCateByPage(int page , int size);
}
