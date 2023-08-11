package com.example.ecommercewebsite.Service;


import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.repository.ProductsRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductsRepository productsRepository;

    public List<Product> getProducts() {
        return productsRepository.findAll();
    }
    public void addProduct(Product product) {
        productsRepository.add(product);
    }

    public Product updateProduct(Integer productId,Product product){
     try{
         var updateProduct = productsRepository.findAll().stream().filter(p -> p.getProductId().equals(productId)).findFirst().orElseThrow();
         updateProduct.setProductId(product.getProductId());
         updateProduct.setProductName(product.getProductName());
         updateProduct.setProductPrice(product.getProductPrice());
     }catch (NoSuchElementException exception){
         throw new NotFoundException("Merchant ID" + productId + "not found");
     }
     return productsRepository.updateProduct(product);
    }

    public void deleteProduct(Integer productId){
        productsRepository.removeById(productId);
    }

}
