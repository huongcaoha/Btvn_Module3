package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;
    @GetMapping
    public String display(Model model, @RequestParam(value = "page",defaultValue = "1") int page , @RequestParam(value = "size",defaultValue = "5") int size){
        List<User> users = userService.getList(page,size);
        double totalPage = userService.getTotalPage(size,page);
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("users" , users);
        return "user/display";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user",new User());
        return "user/create";
    }

    @PostMapping("create")
    public String add(@ModelAttribute @Valid User user , BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("user",user);
            return "/user/create";
        }
        if(userService.add(user)){
            return "redirect:/user";
        }else {
//            model.addAttribute("phoneErr","phone exist !");
            return "/user/create";
        }
    }
}
