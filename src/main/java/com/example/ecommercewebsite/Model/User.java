package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "should be not empty")
    private Integer userId;
    @NotEmpty(message = "should be not empty")
    @Size(min = 5 , message = "should be more then 5 characters")
    private String userName;

    @NotEmpty(message = "should be not empty")
    @Size(min = 6 , message = "should be more then 6 characters")
    @Pattern(regexp ="^[a-zA-Z0-9\\s]+$")
    private String passWord;

    @Email(message = "only email")
    private String email;

    @NotEmpty(message = "should be not empty")
    @Pattern(regexp="(admin|customer)",message = "should be admin or customer")
    private String role;

    @NotEmpty(message = "should be not empty")
    @Positive
    private Double balance;
}
