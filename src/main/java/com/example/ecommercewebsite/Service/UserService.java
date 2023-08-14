package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.User;
import com.example.ecommercewebsite.repository.ProductsRepository;
import com.example.ecommercewebsite.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;
    private final MerchantStockService merchantStockService;
    private final MerchantService merchantService;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.add(user);
    }

    public User updateUser(Integer userId, User user) {
        if (isNotAuthorized(userId, user))
            throw new IllegalArgumentException("Not allowed to update other users profile");

        return userRepository.update(user);
    }


    public void removeUser(Integer userId) {
        userRepository.removeById(userId);
    }

    public void buyAProduct(Integer userId, Integer productId, Integer merchantId) {
        try {
            var user = userRepository.findAll().stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElseThrow();
            var product =productsRepository.findAll().stream().filter(p -> p.getProductId().equals(productId)).findFirst().orElseThrow();
            var merchant = merchantService.findAll().stream().filter(m -> m.getMerchantId().equals(merchantId)).findFirst().orElseThrow();
            var stock = merchantStockService.findAll().stream().filter(s -> s.getProductId().equals(productId) && s.getMerchantId().equals(merchantId)).findFirst().orElseThrow();
            if (user.getBalance() < product.getProductPrice()) {
                throw new IllegalArgumentException("User did not have enough balance to buy the product");
            }
            user.setBalance(user.getBalance() - product.getProductPrice());
            stock.setStock(stock.getStock()-1);

        } catch (NoSuchElementException exception) {
            throw new NotFoundException("Could not find Product in stock for  " + productId + " and merchant " + merchantId);

        }


    }


    private boolean isNotAuthorized(Integer userId, User user) {
        return !userId.equals(user.getUserId());
    }

}
