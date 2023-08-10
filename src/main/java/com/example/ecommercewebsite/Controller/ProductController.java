package com.example.ecommercewebsite.Controller;
import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Service.CategoryService;
import com.example.ecommercewebsite.Service.ProductService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/products/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService products;
    private final CategoryService categoryService;

  @GetMapping("getProducts")
    public ArrayList<Product> getProducts() {
      return products.getProducts();
  }

  @PostMapping("addProduct")
  public ResponseEntity addProduct(@RequestBody @Valid Product product , Errors errors) {
      if(errors.hasErrors())
      {
          String errormessage = errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(errormessage);
      }
      if(categoryService.checkCategory(product.getCategoryId()))
      {
          products.addProduct(product);
          return ResponseEntity.status(200).body(new ApiResponse("Product added"));
      }
     return ResponseEntity.status(400).body(new ApiResponse("Wrong categoryId"));
  }
  @PutMapping("updateProduct/{productId}")
    public ResponseEntity updateProduct(@PathVariable @Valid Integer productId,@RequestBody @Valid Product product,Errors errors){
      if(errors.hasErrors()){
          String errormessage = errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(errormessage);
      }
      if(categoryService.checkCategory(product.getCategoryId())){
          boolean isUpdate = products.updateProduct(productId, product);
          if(isUpdate){
              return ResponseEntity.status(200).body(new ApiResponse("Update product"));
          }
      }
      return ResponseEntity.status(400).body(new ApiResponse("Wrong CategoryId"));
  }

  @DeleteMapping("deleteProduct")
    public ResponseEntity deleteProduct (@PathVariable @Valid Integer productId){
      boolean isDelete = products.deleteProduct(productId);
      if(isDelete){
          return ResponseEntity.status(200).body(new ApiResponse("Delete product"));
      }
      return ResponseEntity.status(400).body(new ApiResponse("Wrong product"));
  }



}
