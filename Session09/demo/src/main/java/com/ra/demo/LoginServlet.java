package com.ra.demo;

import com.ra.demo.model.entity.Product;
import com.ra.demo.service.ProductInterfaceIpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet" , value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equalsIgnoreCase("huongcaoha") && password.equalsIgnoreCase("123456789")){

            resp.sendRedirect("/home.jsp");
        }else {
            req.setAttribute("rs",true);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
