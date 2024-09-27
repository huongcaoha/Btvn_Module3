package com.ra.controller;

import com.ra.model.dao.UserInterface;
import com.ra.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserInterface userInterface ;
    @RequestMapping("/")
    public String home(Model model){
        List<User> users = userInterface.getListUser();
        model.addAttribute("users",users);
        return "home";
    }
}
