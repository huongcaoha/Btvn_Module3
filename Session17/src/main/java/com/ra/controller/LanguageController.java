package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/language")
public class LanguageController {
    @GetMapping
    public String index(){
        return "demo_language";
    }
}
