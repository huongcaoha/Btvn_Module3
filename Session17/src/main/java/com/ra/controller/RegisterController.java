package com.ra.controller;

import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.model.entity.constant.RoleEnum;
import com.ra.model.service.role.RoleService;
import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService ;

    @Autowired
    private RoleService roleService ;
    @GetMapping
    public String register(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping
    public String handleRegister(@ModelAttribute @Valid User user , BindingResult result, Model model, @RequestParam("confirmPassword") String confirmPassword){
        boolean checkConfirmPassword = user.getPassword().equals(confirmPassword);
        if(result.hasErrors() || !checkConfirmPassword){
            model.addAttribute("user",user);
            model.addAttribute("error","Password confirm not match!");
            return "/register";
        }

        if(userService.add(user)){
            return "redirect:/login";
        }else {
            return "/register";
        }
    }
}
