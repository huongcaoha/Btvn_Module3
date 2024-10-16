//package com.ra.controller;
//
//import com.ra.model.entity.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class HomeController {
//    @RequestMapping("/")
//    public String home(HttpServletRequest request, Model model){
//        HttpSession session = request.getSession();
//       String username = "" ;
//        Boolean loginValue = (Boolean) session.getAttribute("login");
//        boolean login = (loginValue != null) ? loginValue : false;
//       if(login){
//           User user = (User) session.getAttribute("user");
//           username = user.getFullName();
//       }else {
//           username = "Customer" ;
//       }
//        model.addAttribute("login",login);
//        model.addAttribute("username" , username);
//        return "home";
//    }
//}
