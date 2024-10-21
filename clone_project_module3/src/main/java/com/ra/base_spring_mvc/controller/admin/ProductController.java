package com.ra.base_spring_mvc.controller.admin;

import com.ra.base_spring_mvc.model.entity.Product;

import com.ra.base_spring_mvc.model.service.category.CategoryService;
import com.ra.base_spring_mvc.model.service.product.ProductService;
import com.ra.base_spring_mvc.model.service.product.status.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StatusService statusService;
    @GetMapping
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size) {

        List<Product> products = productService.findAll(page,size);
        model.addAttribute("products", products);
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("totalPage",productService.totalPages(size));
        return "admin/product/product-management";
    }
    @GetMapping("/add")
    public String add(Model model,@ModelAttribute("product") Product product) {

        model.addAttribute("statusList", statusService.findAll());
        model.addAttribute("categories", categoryService.getListCategory());

        model.addAttribute("product", product);
        return "admin/product/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError allError : result.getAllErrors()) {
                System.out.println(allError.getDefaultMessage());
            }
            return "admin/product/add";
        }

        productService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Product product=productService.findById(id);
        model.addAttribute("products", product);
        model.addAttribute("categories", categoryService.getListCategory());
        model.addAttribute("statusList", statusService.findAll());
        return "admin/product/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id, @ModelAttribute("product") Product product) {

        if (productService.updateProduct(product)) {
            return "redirect:/product";
        }
        return "admin/product/update" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
    @GetMapping("/search")
    public String search(@RequestParam("search") String productName,Model model,@RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "size", defaultValue = "5") int size){
        List<Product> productList= productService.searchProduct(productName,page,size);
        model.addAttribute("products",productList);
        model.addAttribute("categories", categoryService.getListCategory());
        model.addAttribute("statusList", statusService.findAll());
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("totalPage",productService.totalPages(size));
       return "admin/product/product-management";
    }

}
