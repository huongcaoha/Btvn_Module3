package com.ra.bai1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        double discount = Double.parseDouble(req.getParameter("discount"));
        double discountAmount = price * discount * 0.01 ;
        double discountPrice = price - discountAmount ;
        req.setAttribute("description",description);
        req.setAttribute("price",price);
        req.setAttribute("discount",discount);
        req.setAttribute("discountAmount",discountAmount);
        req.setAttribute("discountPrice",discountPrice);
        req.getRequestDispatcher("result.jsp").forward(req,resp);


    }
}
