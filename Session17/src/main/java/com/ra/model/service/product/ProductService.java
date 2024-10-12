package com.ra.model.service.product;

import com.ra.model.entity.Product;
import com.ra.model.entity.Search;
import com.ra.model.entity.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getList();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(Product product);
    Product findById(int id);
    boolean checkNameExist(String newName , String oldName);
    String uploadImage(MultipartFile file);
    Product converseDTOToProduct(ProductDTO productDTO);
    List<Product> getProductByPage(int page , int size) ;
    double getTotalPage(int totalItem ,int itemPerPage);
    List<Product> searchProduct(Search search , int page , int size);
    boolean checkSearchNull(Search search);
}
