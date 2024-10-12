package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.entity.Search;
import com.ra.model.entity.dto.ProductDTO;
import com.ra.model.service.category.CategoryServiceImpl;
import com.ra.model.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    public static String productOldName = "" ;
    public static Search searchValue = new Search();
    public static boolean searchStatus = true ;
    private final ProductServiceImpl productServiceImpl;

    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl, CategoryServiceImpl categoryServiceImpl) {
        this.productServiceImpl = productServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping
    public String display(Model model,@RequestParam(value = "page",defaultValue = "1") int page , @RequestParam(value = "size",defaultValue = "5") int size){
        List<Product> products = new ArrayList<>();
        products = productServiceImpl.searchProduct(searchValue,page,size);
        double totalPage = 1 ;
        if(productServiceImpl.checkSearchNull(searchValue)){
            totalPage = productServiceImpl.getTotalPage(productServiceImpl.getList().size(),size);
        }else {
            totalPage = productServiceImpl.getTotalPage(products.size(),size);
        }
        Search search = searchValue;
        if(search.getDescription() == null){
            search.setDescription("");
        }

        List<Category> categories = categoryServiceImpl.getList();
        model.addAttribute("categories", categories);
        model.addAttribute("search" , search);
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("products",products);
        return "/admin/product/display" ;
    }

    @PostMapping
    public String show( @ModelAttribute("search") Search search){
        searchValue = search ;
        return "redirect:/product" ;
    }

    @GetMapping("/create")
    public String create(Model model){
        ProductDTO productDTO = new ProductDTO();
        List<Category> categories = categoryServiceImpl.getList();
        model.addAttribute("categories", categories);
        model.addAttribute("product",productDTO);
        return "/admin/product/create";
    }

    @PostMapping("create")
    public String add(@ModelAttribute("product") @Valid ProductDTO productDTO, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("product",productDTO);
            List<Category> categories = categoryServiceImpl.getList();
            model.addAttribute("categories", categories);
            return "/admin/product/create" ;
        }
        Product product = productServiceImpl.converseDTOToProduct(productDTO);
        if(productServiceImpl.add(product)){
                return "redirect:/product";
        }
        return "/admin/product/create" ;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id , Model model){
        Product product = productServiceImpl.findById(id);
        productOldName = product.getName();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setStatus(product.getStatus());
        productDTO.setCategoryId(product.getCategory().getId());
        List<Category> categories = categoryServiceImpl.getList();
        model.addAttribute("categories",categories);
        model.addAttribute("product",productDTO);
        model.addAttribute("image",product.getImage());
        return "/admin/product/update";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable int id,@ModelAttribute("product") @Valid ProductDTO productDTO , BindingResult result, Model model){
        if(result.hasErrors()){
            Product product = productServiceImpl.findById(id);
            productOldName = product.getName();
            ProductDTO productDTO1 = new ProductDTO();
            productDTO1.setName(product.getName());
            productDTO1.setPrice(product.getPrice());
            productDTO1.setDescription(product.getDescription());
            productDTO1.setStatus(product.getStatus());
            productDTO1.setCategoryId(product.getCategory().getId());
            List<Category> categories = categoryServiceImpl.getList();
            model.addAttribute("categories",categories);
            model.addAttribute("product",productDTO1);
            model.addAttribute("image",product.getImage());
            return "redirect:/product/edit"+id ;
        }
       Product product = productServiceImpl.converseDTOToProduct(productDTO);
       product.setId(id);
        if(productServiceImpl.update(product)){
            return "redirect:/product";
        }else {
            return "redirect:/product/edit"+id ;
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Product product = productServiceImpl.findById(id);
        productServiceImpl.delete(product);
        return "redirect:/product";
    }
}
