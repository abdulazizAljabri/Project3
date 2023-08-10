package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant> merchantList = new ArrayList<>();

    public ArrayList<Merchant> getMerchantList() {
        return merchantList;
    }

    public void addMerchant(Merchant merchant) {
        merchantList.add(merchant);
    }


    public boolean updateMerchant(Integer merchantId ,Merchant merchant) {
        for (int index = 0; index < merchantList.size(); index++) {
            if(merchantList.get(index).getMerchantId().equals(merchantId)){
                merchantList.set(index,merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchant(Integer merchantId){
        for (int index = 0; index < merchantList.size(); index++){
            if(merchantList.get(index).getMerchantId().equals(merchantId)){
                merchantList.remove(index);
                return true;
            }
        }
        return false;
    }

}

