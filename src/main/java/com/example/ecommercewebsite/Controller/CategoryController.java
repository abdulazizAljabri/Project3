package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/categorys/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("get")
    public ArrayList<Category> getCategoryService() {
        return categoryService.getCategorieList();
    }

    @PostMapping("add")
    public ResponseEntity<Object> addCategory(@RequestBody @Valid Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category added"));
    }

    @PutMapping("update/{categoryId}")
    public ResponseEntity updateCategory(@PathVariable @Valid Integer categoryId, @RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            String errormessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errormessage);
        }
        boolean isUpdate = categoryService.updateCategory(categoryId, category);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("Category Updated "));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong category"));
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
