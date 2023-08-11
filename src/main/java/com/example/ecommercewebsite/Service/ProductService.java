package com.example.ecommercewebsite.Service;


import com.example.ecommercewebsite.Model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public void updateProduct(Integer productId,Product product){
     try{
         var updateProduct = products.stream().filter(p -> p.getProductId().equals(productId)).findFirst().orElseThrow();
         updateProduct.setProductId(product.getProductId());
         updateProduct.setProductName(product.getProductName());
         updateProduct.setProductPrice(product.getProductPrice());
     }catch (NoSuchElementException exception){
         throw new NotFoundException("Merchant ID" + productId + "not found");
     }
    }

    public boolean deleteProduct(Integer productId){
        for(int index = 0; index < products.size();index++){
            if(products.get(index).getProductId() == productId){
                products.remove(index);
                return true;
            }
        }
        return false;
    }

}
