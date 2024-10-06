package com.ra.model.service;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO ;

   public  List<Category> getListCategory(){
       return categoryDAO.getListCategory();
   };
   public  boolean addCategory(Category category){
       return categoryDAO.addCategory(category);
   };
    public   boolean updateCategory(Category category){
       return categoryDAO.updateCategory(category);
    };
   public  boolean deleteCategory(Category category){
       return categoryDAO.deleteCategory(category);
   };
   public  Category findById(int id){
       return categoryDAO.findById(id);
   };
}
