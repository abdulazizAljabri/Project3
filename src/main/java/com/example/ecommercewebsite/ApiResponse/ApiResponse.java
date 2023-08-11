package com.example.ecommercewebsite.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private Object body;
    private Integer status;


    public ApiResponse(String message) {
        this.message = message;
    }
}
