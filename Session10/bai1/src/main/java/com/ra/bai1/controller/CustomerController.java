package com.ra.bai1.controller;

import com.ra.bai1.model.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController
{
    @RequestMapping("/")
    public String customer(Model model){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"Mai Văn Hoàn","1983-08-20","Hà Nội","/image/huongcaoha.jpg"));
        customers.add(new Customer(2,"Nguyễn Văn Nam","1983-08-21","Bắc Giang","/image/huongcaoha.jpg"));
        customers.add(new Customer(3,"Nguyễn Thái Hòa","1983-08-22","Nam Định","/image/huongcaoha.jpg"));
        customers.add(new Customer(4,"Trần ĐĂng Khoa","1983-08-17","Hà Tây","/image/huongcaoha.jpg"));
        customers.add(new Customer(5,"Nguyễn Đình Thi","1983-08-19","Hà Nội","/image/huongcaoha.jpg"));
        model.addAttribute("customers",customers);
        return "/WEB-INF/customer.jsp";
    }
}
