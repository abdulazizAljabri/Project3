package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.Model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private final List<User> users = new ArrayList<>();


    public List<User> findAll() {
        return this.users;
    }

    public void add(User user) {
        users.add(user);
    }

    public User findById(Integer id) {
        return users.stream().filter(u -> u.getUserId().equals(id)).findFirst().orElseThrow();
    }

    public void removeById(Integer id) {
        var user = findById(id);
        users.remove(user);
    }

    public User update(User user) {
        var updatedUser = findById(user.getUserId());
        updatedUser.setUserName(user.getUserName());
        updatedUser.setEmail(user.getEmail());
        return updatedUser;
    }
}
