package com.ra.controller;

import com.ra.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class ProductCartController {
    @Autowired
    ProductService productService;
    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable int id){
        Pro
    }
}
