package com.example.ecommercewebsite.common;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        return ResponseEntity.status(400).body(new ApiResponse((ex.getFieldError().getDefaultMessage())));
    }


}