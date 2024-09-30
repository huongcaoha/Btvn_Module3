package com.ra.baitap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bai2" , value = "/bai2")
public class Bai2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/bai2.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double firstNumber = Double.parseDouble(req.getParameter("firstOperand"));
        double lastNumber = Double.parseDouble(req.getParameter("lastOperand"));
        String operator = req.getParameter("operator");
        switch (operator){
            case "addition" : {
                double rs = firstNumber + lastNumber ;
                req.setAttribute("rs", rs);
                break;
            }
            case "subtraction" : {
                double rs = firstNumber - lastNumber ;
                req.setAttribute("rs", rs);
                break;
            }
            case "multiplication" : {
                double rs = firstNumber * lastNumber ;
                req.setAttribute("rs", rs);
                break;
            }
            case "division" : {
                double rs = firstNumber / lastNumber ;
                req.setAttribute("rs", rs);
                break;
            }

        }
        req.setAttribute("firstNumber",firstNumber);
        req.setAttribute("lastNumber",lastNumber);
        doGet(req,resp);
    }
}
