package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/categorys")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ArrayList<Category> getCategoryService() {
        return categoryService.getCategorieList();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody @Valid Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Category has been added",category,HttpStatus.OK.value()));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse>updateCategory(@PathVariable @Valid Integer categoryId, @RequestBody @Valid Category category) {
        categoryService.updateCategory(categoryId, category);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Category has been updated", category, HttpStatus.OK.value()));
    }

    @DeleteMapping("delete/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable Integer categoryId) {
        boolean isDelete = categoryService.deleteCategory(categoryId);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("Category deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong category"));
    }


}
