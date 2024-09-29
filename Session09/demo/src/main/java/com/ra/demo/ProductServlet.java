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



@WebServlet(name = "product" , value = "/product")
public class ProductServlet extends HttpServlet {
    public static ProductInterfaceIpl productInterfaceIpl = new ProductInterfaceIpl();
    public static List<Product> products = productInterfaceIpl.getListProduct();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    req.setAttribute("products",products);
            req.getRequestDispatcher("product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String productName = req.getParameter("productName");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String description = req.getParameter("description");
        products.add(new Product(id,productName,price,stock,description));
        doGet(req,resp);

    }
}
