package com.ra.base_spring_mvc.controller.user;

import com.ra.base_spring_mvc.model.entity.ProductDetail;
import com.ra.base_spring_mvc.model.entity.ShoppingCart;
import com.ra.base_spring_mvc.model.service.ShoppingCart.ShoppingCartService;
import com.ra.base_spring_mvc.model.service.productdetail.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
   private final ProductDetailService productDetailService;
    private final ShoppingCartService shoppingCartService;

    public CartController(ProductDetailService productDetailService, ShoppingCartService shoppingCartService) {
        this.productDetailService = productDetailService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String displayCart(Model model){
        List<ShoppingCart> shoppingCarts = shoppingCartService.getListShoppingCart(1);

        model.addAttribute("shoppingCarts", shoppingCarts);
        return "user/cart/displayCart";
    }

    @PostMapping("/addToCart/{id_Product_detail}")
    public String addToCart(@PathVariable int id_Product_detail){
        ProductDetail productDetail = productDetailService.findById(id_Product_detail);

        return "";
    }

    @GetMapping("/up/{id}")
    public String up(@PathVariable int id){
        ShoppingCart shoppingCart = shoppingCartService.findById(id);
        shoppingCart.setQuantity(shoppingCart.getQuantity()+1);
        shoppingCartService.updateTocart(shoppingCart);
        return "redirect:/cart";
    }

    @GetMapping("/down/{id}")
    public String down(@PathVariable int id){
        ShoppingCart shoppingCart = shoppingCartService.findById(id);
        shoppingCart.setQuantity(shoppingCart.getQuantity()-1);
        shoppingCartService.updateTocart(shoppingCart);
        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String update(){
        return "";
    }

}
