package com.ra.base_spring_mvc.controller.user;

import com.ra.base_spring_mvc.model.service.banner.BannerService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller

@RequestMapping("/")
public class HomeController {
    @Autowired
    private BannerService bannerService;
    @GetMapping
    public String indexhome(HttpServletRequest request){
        String bannerTop = "/uploads/" + bannerService.getBannerByLocation("top").getImage();
        String bannerLeft = "/uploads/" + bannerService.getBannerByLocation("left").getImage();
        String bannerRight = "/uploads/" + bannerService.getBannerByLocation("right").getImage();
       HttpSession session = request.getSession();
       session.setAttribute("bannerTop",bannerTop);
       session.setAttribute("bannerLeft",bannerLeft);
       session.setAttribute("bannerRight",bannerRight);
        return "user/home";
    }
}
