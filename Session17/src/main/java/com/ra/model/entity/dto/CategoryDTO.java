package com.ra.model.entity.dto;

import com.ra.model.entity.Product;
import com.ra.model.service.validator.category.CategoryUnique;
import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Set;

public class CategoryDTO {
    @Size(min = 3 , message = "Minimum name 3 characters")
    @CategoryUnique(message = "Category name existed")
    private String name ;
    private String oldName ;
    private String description ;

    private boolean status ;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
