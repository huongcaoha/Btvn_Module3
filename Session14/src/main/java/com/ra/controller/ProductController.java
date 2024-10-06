package com.ra.controller;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import com.ra.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        return "/product/display";
    }

    @GetMapping("/create")
    public String create(Model model){
        Product product = new Product();
        List<Category> categories = categoryService.getListCategory();
        model.addAttribute("categories" , categories);
        model.addAttribute("product",product);
        return "/product/create";
    }

    @PostMapping("/create")
    public String add(Model model, @ModelAttribute Product product, @RequestParam("image") MultipartFile image) {
        // Kiểm tra xem file có được chọn không
        if (!image.isEmpty()) {
            try {
                String filePath = "C:/Users/dell/IdeaProjects/Btvn_Module3/Session14/src/main/resources/images" + image.getOriginalFilename(); // Cập nhật đường dẫn
                File dest = new File(filePath);
                image.transferTo(dest);
                product.setImage("images/" + image.getOriginalFilename()); // Đường dẫn hình ảnh
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("error", "Lỗi khi tải lên hình ảnh!");
                return "product/create"; // Đảm bảo đường dẫn chính xác
            }
        }

        // Kiểm tra và lưu sản phẩm
        if (productService.add(product)) {
            return "redirect:/product";
        } else {
            model.addAttribute("error", "Lỗi không thể tạo sản phẩm!");
            return "product/create"; // Đảm bảo đường dẫn chính xác
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Product product = productService.findById(id);
        productService.delete(product);
        return "redirect:/product";
    }

    @PostMapping("demo")
    public String demo1(@RequestParam("image")MultipartFile image,Model model){
        if(!image.isEmpty()){
            try {
                String filePath = "C:/Users/dell/IdeaProjects/Btvn_Module3/Session14/src/main/resources/" + image.getOriginalFilename() ;
                File dest = new File(filePath);
                image.transferTo(dest);
                model.addAttribute("image","/images" +image.getOriginalFilename());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "product/demo";
    }

    @GetMapping("/demo")
    public String demo(){
        return "product/demo";
    }
}


