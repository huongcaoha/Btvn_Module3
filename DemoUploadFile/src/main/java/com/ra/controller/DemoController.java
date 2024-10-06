package com.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class DemoController {
    @Autowired
    private ServletContext servletContext;
    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }
    @PostMapping("/demo")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String filePath = "C:/Users/dell/IdeaProjects/Btvn_Module3/DemoUploadFile/src/main/resources/" + file.getOriginalFilename();
                File dest = new File(filePath);
                file.transferTo(dest);
                // Xử lý thêm nếu cần
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/upload/demo"; // Hoặc đến trang thành công
    }
}
