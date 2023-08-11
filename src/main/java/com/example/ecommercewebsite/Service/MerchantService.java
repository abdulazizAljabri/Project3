package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Product> productList = new ArrayList<>();
    ArrayList<MerchantStock> merchantStockList = new ArrayList<>();
    ArrayList<Merchant> merchantList = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStockList() {
        return merchantStockList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
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

    public boolean addMoreStock(Integer productId , Integer merchantId , Integer amount ){
       for(int index = 0; index < merchantList.size(); index++){
           if(merchantList.get(index).getMerchantId().equals(merchantId)){
               for (int index2 = 0; index2 < merchantStockList.size(); index2++){
                   if(merchantStockList.get(index2).getProductId().equals(productId)){
                      int newStock = merchantStockList.get(index2).getStock() + amount;
                      merchantStockList.get(index2).setStock(newStock);
                      return true;
                   }
                   }
               }
           }
              return false;
       }
    }



