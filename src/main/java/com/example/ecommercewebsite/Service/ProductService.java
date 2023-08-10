package com.example.ecommercewebsite.Service;


import com.example.ecommercewebsite.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(Integer productId,Product product){
        for(int index = 0; index < products.size(); index++){
            if(products.get(index).getProductId() == productId){
                products.set(index, product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(Integer productId,Product product){
        for(int index = 0; index < products.size();index++){
            if(products.get(index).getProductId() == productId){
                products.remove(index);
                return true;
            }
        }
        return false;
    }

}
