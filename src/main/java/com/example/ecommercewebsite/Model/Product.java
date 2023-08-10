package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {


    @NotNull(message = "Should be not empty")
    private Integer productId;

    @NotEmpty(message = "Should be not empty")
    @Size(min = 3 , message = "Should be more then 3 characters")
    private String productName;

    @NotNull(message = "Should be not empty")
    @Positive
    private Double productPrice;

    @NotNull(message = "Should be not empty")
    private Integer categoryId;

}
