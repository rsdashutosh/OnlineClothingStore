package com.app.dtos;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.app.enums.CategoryType;
import com.app.enums.Gender;
import com.app.pojos.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CategoryDto {
    
    @NotBlank(message = "Category name is required")
    private String categoryName;

    @NotNull(message = "Category gender is required")
    private Gender categoryGender;

    @NotNull(message = "Category type is required")
    private CategoryType categoryType;

    @Size(min = 1, message = "At least one product must be associated")
    private List<Product> products;

    // Getters and setters
}
