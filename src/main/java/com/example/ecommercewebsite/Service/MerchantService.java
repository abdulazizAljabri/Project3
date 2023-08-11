package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MerchantService {
    ArrayList<Product> productList = new ArrayList<>();
    ArrayList<MerchantStock> merchantStockList = new ArrayList<>();
    ArrayList<Merchant> merchantList = new ArrayList<>();


    private final MerchantStockService merchantStockService;

    public ArrayList<Merchant> getMerchantList() {
        return merchantList;
    }

    public Merchant addMerchant(Merchant merchant) {
        merchantList.add(merchant);
        return merchant;
    }


    public void updateMerchant(Integer merchantId, Merchant merchant) {

        try {
            var updatedMerchant = merchantList.stream().filter(m -> m.getMerchantId().equals(merchantId)).findFirst().orElseThrow();
            updatedMerchant.setMerchantId(merchant.getMerchantId());
            updatedMerchant.setMerchantName(merchant.getMerchantName());
        } catch (NoSuchElementException exception) {
            throw new NotFoundException("Merchant ID" + merchantId + "not found");
        }


    }

    public boolean deleteMerchant(Integer merchantId) {
        for (int index = 0; index < merchantList.size(); index++) {
            if (merchantList.get(index).getMerchantId().equals(merchantId)) {
                merchantList.remove(index);
                return true;
            }
        }
        return false;
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



