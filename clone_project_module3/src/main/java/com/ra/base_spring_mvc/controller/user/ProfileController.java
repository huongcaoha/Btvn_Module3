package com.ra.base_spring_mvc.controller.user;

import com.ra.base_spring_mvc.model.entity.User;
import com.ra.base_spring_mvc.model.service.user.UserService;
import com.ra.base_spring_mvc.model.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController
{
    @Autowired
    private UserService userService;
    @GetMapping
    public String displayProfile(Model model , HttpServletRequest request){
//        HttpSession session = request.getSession();
//        User user = new User();
//        if(session.getAttribute("user") != null){
//            user = (User) session.getAttribute("user");
//            model.addAttribute("user",user);
//            return  "user/profile/displayProfile" ;
//        }else {
//            return "user/login";
//        }
        User user = new User();
        user.setId(1);
        user.setAddress("hoài đức");
        user.setEmail("huongcoha@gmail.com");
        user.setFullName("Nguyễn Công Hưởng");
        user.setPhone("0367508795");
        user.setPassword("123456789");
        user.setImage("anh2.png");
        user.setUsername("huongcaoha1994");
        model.addAttribute("user",user);
        return  "user/profile/displayProfile" ;
    }

    @GetMapping("/order")
    public String listOrder(Model model){
        return "";
    }
}
