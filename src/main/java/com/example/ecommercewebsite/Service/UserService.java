package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean updateUser(Integer userId,User user) {
        for (int index = 0; index < users.size(); index++) {
            if (users.get(index).getUserId().equals(userId)){
                users.set(index, user);
                return true;
            }
        }
        return false;
    }

    public boolean removeUser(Integer userId){
        for (int index = 0; index < users.size() ;index++){
            if (users.get(index).getUserId().equals(userId)){
                users.remove(index);
                return true;
            }
        }
        return false;
    }

//    public boolean userBuy(Integer userId ,Integer productId,Integer merchantId){
//        for (int index = 0; index < users.size(); index++){
//            if (users.get(index).getUserId().equals(userId)){
//                for (index = 0; index <p)
//            }
//        }
//    }

}
