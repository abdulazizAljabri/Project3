package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty(message = "should be not empty")
    private Integer categoryId;

    @NotEmpty(message = "should be not empty")
    @Size(min = 3 , message = "should be more then 3 characters")
    private String categoryName;

}
