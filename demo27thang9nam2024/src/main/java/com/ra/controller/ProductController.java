package com.ra.controller;

import com.ra.model.entity.Product;
import com.ra.model.service.ProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/product")
    public String showProduct(Model model){
        ProductImpl productImpl = new ProductImpl();
        List<Product> products = productImpl.getListProduct();
        model.addAttribute("products",products);
        return "product" ;
    }
    @GetMapping("/addProduct")
    public String showFormAddProduct(){
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(HttpServletRequest request, @RequestParam MultipartFile file, Model model) {
        request.getCharacterEncoding();
        String fileName = null;
        String filePath = null;

        if (file != null && !file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                filePath = "/image" + fileName; // Đường dẫn hợp lệ
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Error saving image file.");
                return "addProduct"; // Trả về form nếu có lỗi
            }
        }
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String description = request.getParameter("description");
        ProductImpl productImpl = new ProductImpl();
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setStock(stock);
        product.setDescription(description);
        product.setImage(filePath);

        boolean rs = productImpl.addProduct(product);
        if (rs) {
            return "product";
        } else {
            model.addAttribute("message", "Add product error!");
            return "addProduct";
        }
    }
}

