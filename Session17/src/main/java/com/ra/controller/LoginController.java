package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public String handleLogin(@RequestParam("phone") String phone , @RequestParam("password") String password){
        User user = userService.checkUserExist(phone,password);
        if(user == null){
            return "login";
        }else {
            return "redirect:/admin";
        }
    }
}
