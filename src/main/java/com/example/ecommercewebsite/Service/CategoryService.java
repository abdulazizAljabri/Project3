package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategorieList() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public boolean updateCategory(Integer categoryId,Category category){
        for (int index = 0; index < categories.size(); index++){
            if (categories.get(index).getCategoryId() == categoryId){
                categories.set(index, category);
                return true;
            }
        }
        return false;
    }




}
