package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.category.CategoryServiceImpl;
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

    private final ProductService productService ;

    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
    public ProductController(ProductService productService, CategoryServiceImpl categoryServiceImpl) {
        this.productService = productService;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping
    public String display(Model model){
        List<Product> products = productService.getList();
        model.addAttribute("products",products);
        return "/admin/product/display" ;
    }

    @GetMapping("/create")
    public String create(Model model){
        Product product = new Product();
        List<Category> categories = categoryServiceImpl.getList();
        model.addAttribute("categories", categories);
        model.addAttribute("product",product);
        return "/admin/product/create";
    }

    @PostMapping("create")
    public String add(@ModelAttribute @Valid Product product, BindingResult result, @RequestParam("img")MultipartFile img ){
        if(result.hasErrors()){
            return "/admin/product/create" ;
        }

        if(img.getSize() > 0){
            String filePath = "C:\\Users\\dell\\IdeaProjects\\Btvn_Module3\\Session17\\src\\main\\webapp\\uploads\\" + img.getOriginalFilename() ;
            File fl = new File(filePath);
            try {
                img.transferTo(fl);
                product.setImage( img.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(productService.add(product)){
                return "redirect:/product";
            }
        }
        return "/admin/product/create" ;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id , Model model){
        Product product = productService.findById(id);
        List<Category> categories = categoryServiceImpl.getList();
        model.addAttribute("categories",categories);
        model.addAttribute("product",product);
        return "/admin/product/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @RequestParam("img") MultipartFile img,@ModelAttribute Product product){
        if(img.getSize() > 0){
            String filePath = "C:\\Users\\dell\\IdeaProjects\\Btvn_Module3\\Session17\\src\\main\\webapp\\uploads\\" + img.getOriginalFilename() ;
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
