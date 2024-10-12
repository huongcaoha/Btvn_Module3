package com.ra.model.service.product;

import com.ra.model.dao.ManagementInterface;
import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.dao.product.ProductDAO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.entity.Search;
import com.ra.model.entity.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    CategoryDAO categoryDAO ;

    @Override
    public List<Product> getList() {

        return productDAO.getList();
    }

    @Override
    public boolean add(Product object) {
        return productDAO.add(object);
    }

    @Override
    public boolean update(Product object) {
        return productDAO.update(object);
    }

    @Override
    public boolean delete(Product object) {
        return productDAO.delete(object);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean checkNameExist(String newName, String oldName) {
        List<Product> products = getList();

        int count = 0 ;
        if(oldName != null){
            count = (int) products.stream().filter(product -> product.getName().equalsIgnoreCase(newName) && !product.getName().equals(oldName)).count();
        }else {
            count = (int) products.stream().filter(product -> product.getName().equalsIgnoreCase(newName)).count();
        }

        return count > 0 ;
    }

    @Override
    public String uploadImage(MultipartFile file) {
        if(file.getSize() > 0){
            String filePath = "C:\\Users\\dell\\IdeaProjects\\Btvn_Module3\\Session17\\src\\main\\webapp\\uploads\\" + file.getOriginalFilename() ;
            File fl = new File(filePath);
            if(!fl.exists()){
                try {
                    fl.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                file.transferTo(fl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
          return file.getOriginalFilename();
        }
        return null ;
    }

    @Override
    public Product converseDTOToProduct(ProductDTO productDTO) {
        Category category = categoryDAO.findById(productDTO.getCategoryId());
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setImage(uploadImage(productDTO.getImage()));
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        product.setStatus(productDTO.getStatus());
        return product;
    }

    @Override
    public List<Product> getProductByPage(int page, int size) {
        return productDAO.getProductByPage(page,size);
    }

    @Override
    public double getTotalPage(int totalItem ,int itemPerPage) {
        return Math.ceil((double) totalItem / itemPerPage);
    }

    @Override
    public List<Product> searchProduct(Search search, int page, int size) {
        return productDAO.searchProduct(search,page,size);
    }

    @Override
    public boolean checkSearchNull(Search search) {
        return productDAO.checkSearchNull(search);
    }


}
