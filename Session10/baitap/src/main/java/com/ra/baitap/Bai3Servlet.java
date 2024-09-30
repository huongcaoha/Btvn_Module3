package com.ra.baitap;

import com.ra.baitap.model.entity.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Configuration
@WebServlet(name = "bai3" , value = "/bai3")
public class Bai3Servlet extends HttpServlet  {
   public static List<Product> products = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        products.add(new Product(1,"Bim Bim" ,"/images/bimbim.png",1200,12));
        products.add(new Product(2,"Coca Cola" ,"/images/coca.png",1500,5));
        products.add(new Product(3,"Khoai Tây" ,"/images/khoaitay.png",2000,9));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products",products);
        req.getRequestDispatcher("/WEB-INF/bai3_display.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        switch (action){
//
//        }
    }
}
