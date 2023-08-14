package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Merchant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MerchantService {

   private  final MerchantStockService merchantstockservice;
    private final List<Merchant> merchantList = new ArrayList<>();

    public List<Merchant> findAll() {
        return this.merchantList;
    }

    public void add(Merchant merchant) {
        merchantList.add(merchant);
    }

    public Merchant findById(Integer merchantId) {
        return merchantList.stream().filter(m -> m.getMerchantId().equals(merchantId)).findFirst().orElseThrow();
    }

    public void removeById(Integer merchantId) {
        var merchant = findById(merchantId);
        merchantList.remove(merchant);
    }

    public Merchant updateMerchant(Merchant merchant , Integer merchantId) {
        var updateMerchant = findById(merchant.getMerchantId());
        updateMerchant.setMerchantName(merchant.getMerchantName());
        return updateMerchant;
    }

        public void addMoreStock(Integer productId, Integer merchantId, Integer amount) {
            try {
                var merchantStock = merchantstockservice.findAll().stream().filter(stock -> stock.getMerchantId().equals(merchantId) && stock.getProductId().equals(productId)).findFirst().orElseThrow();
                merchantStock.setStock(merchantStock.getStock() + amount);
            } catch (NoSuchElementException exception) {
                throw new NotFoundException("Could not find merchent stock for product " + productId + " and merchant " + merchantId);
            }

        }
    }




