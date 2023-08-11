package com.example.ecommercewebsite.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;
    private Integer status;


    public ApiResponse(String message) {
        this.message = message;
    }
}
