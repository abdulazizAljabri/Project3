package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStockList = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStockList() {
        return merchantStockList;
    }
    public void addMerchantStock(MerchantStock stock) {
        merchantStockList.add(stock);
    }

    public boolean updateMerchantStock( Integer merchantStockId ,MerchantStock stock){
        for(int index = 0; index < merchantStockList.size(); index++){
            if(merchantStockList.get(index).getMerchantStockId().equals(merchantStockId)){
                merchantStockList.set(index,stock);
                return true;
            }
        }
        return false;
    }
    public boolean deleteMerchantStock(Integer merchantStockId){
        for (int index = 0; index < merchantStockList.size(); index++){
            if(merchantStockList.get(index).getMerchantStockId().equals(merchantStockId)){
                merchantStockList.remove(index);
                return true;
            }
        }
        return false;
    }

}
