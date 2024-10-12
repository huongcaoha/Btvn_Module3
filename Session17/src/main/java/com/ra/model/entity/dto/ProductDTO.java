package com.ra.model.entity.dto;

import com.ra.model.entity.Category;
import com.ra.model.service.validator.product.ProductUnique;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ProductDTO {
    @ProductUnique
    @NotBlank(message = "name not blank")
    private String name ;

    @Min(value = 1 , message = "price  > 0 !")
    @NotNull(message = "price not blank")
    private double price ;

    private String description ;
    @NotNull(message = "status not null")
    private int status ;

    @NotNull(message = "image not blank")
    private MultipartFile image ;

    @NotNull(message = "category not blank")
    private int categoryId ;

    public ProductDTO() {
    }

    public ProductDTO(String name, double price, String description, int status, MultipartFile image, int categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.image = image;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
