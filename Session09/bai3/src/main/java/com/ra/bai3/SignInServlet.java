package com.ra.bai3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signIn" , value = "/signIn")

public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equalsIgnoreCase("huongcaoha") && password.equalsIgnoreCase("123456789")){
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }else {
            req.setAttribute("status",true);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
