package com.ra.controller;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;
    @GetMapping
    public String display(Model model){
        List<Category> categories = categoryService.getListCategory();
        model.addAttribute("categories",categories);
        return "category/display";
    }
    @GetMapping("/create")
    public String create(Model model){
        Category category = new Category();
        category.setStatus(true);
        model.addAttribute("category",category);
        return "category/create";
    }

    @PostMapping("/create")
    public String add(Model model , @ModelAttribute Category category){
        if(categoryService.addCategory(category)){
            return "redirect:/category";
        }else {
            return "category/create";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/update";
    }

    @PostMapping("/edit/{id}")
    public String update(Model model , @PathVariable int id , @ModelAttribute Category category){
        category.setId(id);
        if(categoryService.updateCategory(category)){
            return "redirect:/category";
        }else {
            return "/category/update";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        Category category = categoryService.findById(id);
        categoryService.deleteCategory(category);
            return "redirect:/category";
    }
}
