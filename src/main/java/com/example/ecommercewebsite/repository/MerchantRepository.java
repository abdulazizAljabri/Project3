package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.Model.Merchant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MerchantRepository {
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

    public Merchant updateMerchant(Merchant merchant) {
        var updateMerchant = findById(merchant.getMerchantId());
        updateMerchant.setMerchantName(merchant.getMerchantName());
        return updateMerchant;
    }

}
