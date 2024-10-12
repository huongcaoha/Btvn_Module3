package com.ra.model.service.category;

import com.ra.model.dao.ManagementInterface;
import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import com.ra.model.entity.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO ;
    @Override
    public List<Category> getList() {
        return categoryDAO.getList();
    }

    @Override
    public boolean add(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setStatus(categoryDTO.isStatus());
        return categoryDAO.add(category);
    }

    @Override
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public boolean delete(Category category) {
        return categoryDAO.delete(category);
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public CategoryDTO converseCategory(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setStatus(category.isStatus());
        return categoryDTO ;
    }

    @Override
    public List<Category> getCateByPage(int page, int size) {
        return categoryDAO.getCateByPage(page,size);
    }

    public boolean checkNameExist(String newName,String oldName){
        List<Category> categories = getList();

        int count = 0 ;
        if(oldName != null){
            count = (int) categories.stream().filter(category -> category.getName().equalsIgnoreCase(newName) && !category.getName().equals(oldName)).count();
        }else {
            count = (int) categories.stream().filter(category -> category.getName().equalsIgnoreCase(newName)).count();
        }

        return count > 0 ;
    }
}
