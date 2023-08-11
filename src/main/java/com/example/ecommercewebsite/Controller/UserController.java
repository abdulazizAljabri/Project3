package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getUsers() {
        var users = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("user has been created", users, HttpStatus.OK.value()));

    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("user has been created", user, HttpStatus.CREATED.value()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Integer userId, @RequestBody User user) {
        var updatedUser = userService.updateUser(userId, user);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("user has been updated", updatedUser, HttpStatus.CREATED.value()));

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {

        userService.removeUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("user has been deleted"));

    }
    // missing method for user can buy product.
}
