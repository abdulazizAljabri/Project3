package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.Model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductsRepository {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Product findById(Integer id){
        return products.stream().filter(product -> product.getProductId().equals(id)).findFirst().orElseThrow();
    }

    public void removeProduct(Integer id){
        var product = findById(id);
        products.remove(product);
    }
    public Product updateProduct(Product product){
        var updatedProduct = findById(product.getProductId());
        updatedProduct.setProductPrice(product.getProductPrice());
        updatedProduct.setCategoryId(product.getCategoryId());
        return updatedProduct;
    }
}
