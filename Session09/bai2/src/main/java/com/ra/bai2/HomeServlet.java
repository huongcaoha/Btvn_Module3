package com.ra.bai2;

import com.ra.bai2.model.entity.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "home" , value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserData userData = new UserData(1,"Huấn","huanrose@gmail.com",30);
        req.setAttribute("user",userData);
        req.getRequestDispatcher("Display.jsp").forward(req,resp);
    }
}
