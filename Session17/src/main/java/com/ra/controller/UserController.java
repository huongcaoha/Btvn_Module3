package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;
    @GetMapping
    public String display(Model model){
        List<User> users = userService.getList();
        model.addAttribute("users" , users);
        return "user/display";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user",new User());
        return "user/create";
    }

    @PostMapping("create")
    public String add(@ModelAttribute @Valid User user , BindingResult result){
        if(result.hasErrors()){
            return "/user/create";
        }
        if(userService.add(user)){
            return "redirect:/user";
        }else {
            return "/user/create";
        }
    }
}
