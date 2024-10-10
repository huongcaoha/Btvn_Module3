package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.dto.CategoryDTO;
import com.ra.model.service.category.CategoryServiceImpl;
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
    private CategoryServiceImpl categoryServiceImpl;
    @GetMapping
    public String display(Model model , @RequestParam(value = "page" ,defaultValue = "1") int page , @RequestParam(value = "size",defaultValue = "5") int size){
        List<Category> categories = categoryServiceImpl.getCateByPage(page,size);
        double totalPage = Math.ceil((double) categoryServiceImpl.getList().size() / size);
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("categories",categories);
        return "admin/category/display";
    }

    @GetMapping("/create")
    public String create(Model model ,  CategoryDTO categoryDTO){
        model.addAttribute("category",categoryDTO);
        return "admin/category/create";
    }

    @PostMapping("/create")
    public String add(@Valid @ModelAttribute(name = "category") CategoryDTO categoryDTO , BindingResult result){
        if(result.hasErrors()){
            return "admin/category/create";
        }

        if(categoryServiceImpl.add(categoryDTO)){
            return "redirect:/category";
        }else {
            return "admin/category/create";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id , Model model){
        Category category = categoryServiceImpl.findById(id);
        CategoryDTO categoryDTO = categoryServiceImpl.converseCategory(category);
        model.addAttribute("category",categoryDTO);
        return "admin/category/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id ,@Valid @ModelAttribute("category") CategoryDTO categoryDTO , BindingResult result){
        Category category = new Category();
        category.setId(id);
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setStatus(categoryDTO.isStatus());
        if(result.hasErrors()){
            return "admin/category/update";
        }
        if(categoryServiceImpl.update(category)){
            return "redirect:/category";
        }else {
            return "admin/category/update";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Category category = categoryServiceImpl.findById(id);
        if(categoryServiceImpl.delete(category)){
            return "redirect:/category";
        }else {
            return "admin/category/update";
        }
    }

}
