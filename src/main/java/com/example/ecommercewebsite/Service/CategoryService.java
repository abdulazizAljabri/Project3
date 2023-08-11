package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();

    public ArrayList<Category> getCategorieList() {
        return categories;
    }

    public Category addCategory(Category category) {
        categories.add(category);
        return category;
    }

    public void updateCategory(Integer categoryId,Category category){
        try{
            var UpdatedCategories = categories.stream().filter(c -> c.getCategoryId()== categoryId).findFirst().orElseThrow();
            UpdatedCategories.setCategoryId(category.getCategoryId());
            UpdatedCategories.setCategoryName(category.getCategoryName());
        }catch (NoSuchElementException exception){
            throw new NotFoundException("Category "+ category.getCategoryId() + " does not exist");
        }


    }

    public boolean deleteCategory(Integer categoryId){
        for (int index = 0 ; index < categories.size() ; index++){
            if(categories.get(index).getCategoryId() == categoryId){
                categories.remove(index);
                return true;
            }
        }
        return false;
    }

    // for checking category before add products
    public boolean checkCategory(Integer categoryId){
        for (int index = 0; index < categories.size(); index++){
            if(categories.get(index).getCategoryId() == categoryId){
                return true;
            }
        }
        return false;
    }

}
