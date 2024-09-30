package com.ra.baitap;

import com.ra.baitap.model.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(name = "bai4" , value = "/bai4")
@MultipartConfig
public class Bai4Servlet extends HttpServlet {
    private static final String UPLOAD_DIR = "src/main/resources/images";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("WEB-INF/bai4.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Product product = new Product();
        product.setId(Bai3Servlet.products.getLast().getId()+1);
        product.setName(req.getParameter("name"));
        product.setPrice(Double.parseDouble(req.getParameter("price")));
        product.setStock(Integer.parseInt(req.getParameter("stock")));

        // Xử lý tải lên ảnh
        Part filePart = req.getPart("image"); // Lấy tệp từ form
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = filePart.getSubmittedFileName();

            // Tạo đường dẫn tuyệt đối đến thư mục images
            String uploadPath = getServletContext().getRealPath("/") + "src/main/resources/images";
            File uploads = new File(uploadPath);

            // Tạo thư mục nếu nó không tồn tại
            if (!uploads.exists()) {
                uploads.mkdirs(); // Tạo thư mục
            }

            // Lưu tệp vào thư mục
            File file = new File(uploads, fileName);
            filePart.write(file.getAbsolutePath());

            product.setImage(fileName);
        } else {
            System.out.println("Không có tệp nào được tải lên.");
        }

        // Thêm sản phẩm vào danh sách
        Bai3Servlet.products.add(product);

        req.setAttribute("products",Bai3Servlet.products);
        req.getRequestDispatcher("/WEB-INF/bai3_display.jsp").forward(req,resp);
    }

}
