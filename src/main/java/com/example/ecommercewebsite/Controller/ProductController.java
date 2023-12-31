package com.example.ecommercewebsite.Controller;
import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Service.CategoryService;
import com.example.ecommercewebsite.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService products ;
    private final CategoryService categoryService;

  @GetMapping("/")
    public List<Product> getProducts() {
      return products.getProducts();
  }

  @PostMapping("/")
  public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid Product product) {
      if(categoryService.checkCategory(product.getCategoryId()))
      {
          products.addProduct(product);
          return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Product has been added", product, HttpStatus.OK.value()));
      }
     return ResponseEntity.status(400).body(new ApiResponse("Wrong categoryId"));
  }
  @PutMapping("/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable @Valid Integer productId,@RequestBody @Valid Product product){
       var updatedProduct = products.updateProduct(productId,product);
      return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Product has been updated", updatedProduct, HttpStatus.OK.value()));
  }

  @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct (@PathVariable @Valid Integer productId){
       products.deleteProduct(productId);
          return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("product has been deleted"));

  }



}
