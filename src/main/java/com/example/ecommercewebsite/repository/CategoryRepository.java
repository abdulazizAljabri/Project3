package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.Model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryRepository {
    ArrayList<Category> categories = new ArrayList<>();

    public List<Category> findAll() {
        return this.categories;
    }
    public void add(Category category){
        categories.add(category);
    }
    public Category findById(Integer id){
        return categories.stream().filter(c -> c.getCategoryId().equals(id)).findFirst().orElseThrow();
    }
    public void removeById(Integer id){
        var category = findById(id);
        categories.remove(category);
    }
    
    public Category updateCategory(Category category){
        var updateCategory = findById(category.getCategoryId());
        updateCategory.setCategoryName(category.getCategoryName());
        updateCategory.setCategoryId(category.getCategoryId());
        return updateCategory;
    }
}
