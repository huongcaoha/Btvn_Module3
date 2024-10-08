package com.ra.controller;

import com.ra.dao.CategoryDAO;
import com.ra.dao.CategoryDAOImpl;
import com.ra.model.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryController" , value = "/category")
public class CategoryController extends HttpServlet {
    private final CategoryDAO categoryDAOImpl = new CategoryDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       List<Category> categories = categoryDAOImpl.getListCate();
        req.setAttribute("categories",categories);
       req.getRequestDispatcher("/views/category.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
