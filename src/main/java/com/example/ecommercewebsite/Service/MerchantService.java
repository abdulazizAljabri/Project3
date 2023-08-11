package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.repository.MerchantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantrepository;


    private final MerchantStockService merchantStockService;

    public ArrayList<Merchant> getMerchantList() {
        return merchantrepository.getAll();
    }

    public Merchant addMerchant(Merchant merchant) {
        merchantrepository.addMerchant(merchant);
        return merchant;
    }


    public void updateMerchant(Integer merchantId, Merchant merchant) {

        try {
            var updatedMerchant = merchantrepository.getAll().stream().filter(m -> m.getMerchantId().equals(merchantId)).findFirst().orElseThrow();
            updatedMerchant.setMerchantId(merchant.getMerchantId());
            updatedMerchant.setMerchantName(merchant.getMerchantName());
        } catch (NoSuchElementException exception) {
            throw new NotFoundException("Merchant ID" + merchantId + "not found");
        }


    }

    public void deleteMerchant(Integer merchantId) {
        merchantrepository.removeMerchant(merchantId);
    }

    public void addMoreStock(Integer productId, Integer merchantId, Integer amount) {
        try {
            var merchantStock = merchantStockService.getMerchantStockList().stream().filter(stock -> stock.getMerchantId().equals(merchantId) && stock.getProductId().equals(productId)).findFirst().orElseThrow();
            merchantStock.setStock(merchantStock.getStock() + amount);
        } catch (NoSuchElementException exception) {
            throw new NotFoundException("Could not find merchent stock for product " + productId + " and merchant " + merchantId);
        }

    }
}



