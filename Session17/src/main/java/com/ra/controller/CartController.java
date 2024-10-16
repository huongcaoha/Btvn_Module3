package com.ra.controller;

import com.ra.model.dao.productCart.ProductCartDAO;
import com.ra.model.entity.Product;
import com.ra.model.entity.ProductCart;
import com.ra.model.entity.User;
import com.ra.model.service.product.ProductService;
import com.ra.model.service.productCart.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductCartService productCartService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ProductService productService ;
    @GetMapping
    public String display(Model model){
     User user = new User();
     if(request.getSession().getAttribute("user") != null){
         user = (User) request.getSession().getAttribute("user");
     }
        List<ProductCart> productCarts = productCartService.getCartById(user.getId());
        model.addAttribute("productCarts",productCarts);
        return "user/cart";
    }

    @GetMapping("/addToCart/{id}")
    public String add(@PathVariable int id){
        User user = new User();
        if(request.getSession().getAttribute("user") != null){
            user = (User) request.getSession().getAttribute("user");
        }else {
            return "redirect:/login";
        }
        Product product = productService.findById(id);
        ProductCart productCart = productCartService.findProductCart(user.getId(),product.getId());
        if(productCart == null){
            productCartService.addToCart(user.getId(), id, 1);
        }else {
            int quantity = productCart.getQuantity() + 1 ;
            productCartService.updateCart(user.getId(), id,quantity);
        }

        return "redirect:/";
    }
}
