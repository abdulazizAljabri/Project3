package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoryService {



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

    public Category updateCategory(Integer categoryId,Category category){
        var updateCategory = findById(category.getCategoryId());
        updateCategory.setCategoryName(category.getCategoryName());
        updateCategory.setCategoryId(category.getCategoryId());
        return updateCategory;
    }

    public boolean checkCategory(Integer categoryId){
        for (int index = 0; index < categories.size(); index++){
            if(categories.get(index).getCategoryId().equals(categoryId)){
                return true;
            }
        }
        return false;
    }

}
