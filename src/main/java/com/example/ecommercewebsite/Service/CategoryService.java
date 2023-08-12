package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        categoryRepository.add(category);
        return category;
    }

    public void updateCategory(Integer categoryId,Category category){
        try{
            var UpdatedCategories = categoryRepository.findAll().stream().filter(c -> c.getCategoryId()== categoryId).findFirst().orElseThrow();
            UpdatedCategories.setCategoryId(category.getCategoryId());
            UpdatedCategories.setCategoryName(category.getCategoryName());
        }catch (NoSuchElementException exception){
            throw new NotFoundException("Category "+ category.getCategoryId() + " does not exist");
        }


    }

    public void deleteCategory(Integer categoryId){
        categoryRepository.removeById(categoryId);
    }

    public boolean checkCategory(Integer categoryId){
        for (int index = 0; index < categoryRepository.findAll().size(); index++){
            if(categoryRepository.findAll().get(index).getCategoryId() == categoryId){
                return true;
            }
        }
        return false;
    }

}
