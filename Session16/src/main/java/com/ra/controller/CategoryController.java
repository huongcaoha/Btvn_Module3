package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;
    @GetMapping
    public String display(Model model){
        List<Category> categories = categoryService.getList();
        model.addAttribute("categories",categories);
        return "category/display";
    }

    @GetMapping("/create")
    public String create(Model model , @Valid Category category){
        model.addAttribute("category",category);
        return "category/create";
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute Category category , BindingResult result){
        if(result.hasErrors()){
            return "category/create";
        }

        if(categoryService.add(category)){
            return "redirect:/category";
        }else {
            return "category/create";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id , Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id ,@Valid @ModelAttribute Category category){
        category.setId(id);
        if(categoryService.update(category)){
            return "redirect:/category";
        }else {
            return "/category/update";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Category category = categoryService.findById(id);
        if(categoryService.delete(category)){
            return "redirect:/category";
        }else {
            return "/category/update";
        }
    }

}
