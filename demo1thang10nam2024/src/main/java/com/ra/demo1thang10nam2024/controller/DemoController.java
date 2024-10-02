package com.ra.demo1thang10nam2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/index")
    public String index(){
        return "index" ;
    }
}
