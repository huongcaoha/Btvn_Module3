package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import com.ra.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService ;
    @Autowired
    private CategoryService categoryService ;
    @GetMapping
    public String display(Model model){
        List<Product> products = productService.getList();
        model.addAttribute("products",products);
        return "product/display" ;
    }

    @GetMapping("/create")
    public String create(Model model){
        Product product = new Product();
        List<Category> categories = categoryService.getList();
        model.addAttribute("categories", categories);
        model.addAttribute("product",product);
        return "product/create";
    }

    @PostMapping("create")
    public String add( @ModelAttribute Product product , @RequestParam("img")MultipartFile img ){
//        if(result.hasErrors()){
//            return "product/create" ;
//        }

        if(img.getSize() > 0){
            String filePath = "C:\\Users\\dell\\IdeaProjects\\Btvn_Module3\\Session16\\src\\main\\webapp\\assets\\images\\" + img.getOriginalFilename() ;
            File fl = new File(filePath);
            try {
                img.transferTo(fl);
                product.setImage("images/" + img.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(productService.add(product)){
                return "redirect:/product";
            }
        }
        return "product/create" ;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id , Model model){
        Product product = productService.findById(id);
        List<Category> categories = categoryService.getList();
        model.addAttribute("categories",categories);
        model.addAttribute("product",product);
        return "product/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @RequestParam("img") MultipartFile img,@ModelAttribute Product product){
        if(img.getSize() > 0){
            String filePath = "C:\\Users\\dell\\IdeaProjects\\Btvn_Module3\\Session16\\src\\main\\resources\\assets\\images\\" + img.getOriginalFilename() ;
            File fl = new File(filePath);
            try {
                img.transferTo(fl);
                product.setImage("images/" + img.getOriginalFilename());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        product.setId(id);
        if(productService.update(product)){
            return "redirect:/product";
        }else {
            return "redirect:/product/edit"+id ;
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Product product = productService.findById(id);
        productService.delete(product);
        return "redirect:/product";
    }
}
