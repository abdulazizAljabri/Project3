package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.Model.Merchant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MerchantRepository {
    ArrayList<Merchant> merchantList = new ArrayList<>();

    public ArrayList <Merchant> getAll(){
        return this.merchantList;
    }
    public void addMerchant(Merchant merchant){
        merchantList.add(merchant);
    }
    public Merchant findById(Integer merchantId){
        return merchantList.stream().filter(m -> m.getMerchantId().equals(merchantId)).findFirst().orElseThrow();
    }

    public void removeMerchant(Integer merchantId){
        var merchant = findById(merchantId);
        merchantList.remove(merchant);
    }

    public Merchant updateMerchant(Merchant merchant){
        var updateMerchant = findById(merchant.getMerchantId());
        updateMerchant.setMerchantName(merchant.getMerchantName());
        return updateMerchant;
    }

}
