package com.ra.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;

@Controller
public class ImageController {

    @GetMapping("/image/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        try {
            // Đường dẫn đến thư mục chứa ảnh
            String imagePath = "C:/Users/dell/IdeaProjects/Btvn_Module3/demo27thang9nam2024/src/main/java/com/ra/util/" + fileName;
            File imageFile = new File(imagePath);

            // Kiểm tra xem file có tồn tại không
            if (!imageFile.exists()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Resource resource = new FileSystemResource(imageFile);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + fileName);

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}