package com.example.ecommercewebsite.Service;

public class NotFoundException extends IllegalArgumentException {

    private final String message;

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
