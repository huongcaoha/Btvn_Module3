package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showFormLogin(){
        return "login";
    }
    @PostMapping("/login")
    public String getFormLogin(String username , String password , Model model){
        if(username.equalsIgnoreCase("huongcaoha") && password.equalsIgnoreCase("123456789")){
            return "home" ;
        }else {
            model.addAttribute("message","username or password not match !");
            return "login";
        }
    }
}
