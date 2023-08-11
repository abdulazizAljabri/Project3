package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("getusers")
    public ArrayList<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("adduser")
    public ResponseEntity addUser(User user) {
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));
    }

    @PutMapping("updateuser/{userId}")
    public ResponseEntity updateUser( @PathVariable Integer userId ,User user) {
        boolean isUpdate = userService.updateUser(userId, user);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("user updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong UserId"));
    }
    @DeleteMapping("deleteuser/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId){
        boolean isDelete = userService.removeUser(userId);
        if (isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong UserId"));
    }
    // missing method for user can buy product.
}
