package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public String handleLogin(@RequestParam("phone") String phone , @RequestParam("password") String password ,  HttpServletRequest request){
        User user = userService.checkUserExist(phone,password);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("login",true);
        if(user == null){
            return "login";
        }else {

            if(user.getRole() == 0) {
                return "redirect:/admin";
            }else {
                return "redirect:/";
            }

        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model){
        User user = new User();
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("login",false);
        return "redirect:/login";
    }
}
