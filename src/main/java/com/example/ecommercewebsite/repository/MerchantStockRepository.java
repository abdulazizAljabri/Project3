package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MerchantStockRepository {
    ArrayList<MerchantStock> stockList = new ArrayList<>();

    public ArrayList<MerchantStock> getAll(){
        return this.stockList;
    }
    public void addStock(MerchantStock stock){
        stockList.add(stock);
    }

    public MerchantStock findStock(Integer id){
        return stockList.stream().filter(stock -> stock.getMerchantStockId().equals(id)).findFirst().orElseThrow();
    }
    public void removeById(Integer id) {
        var user = findStock(id);
        stockList.remove(user);
    }
    public MerchantStock update(MerchantStock stock) {
        var updatedStock = findStock(stock.getMerchantStockId());
        updatedStock.setProductId(stock.getProductId());
        updatedStock.setStock(stock.getStock());
        updatedStock.setMerchantId(stock.getMerchantId());
        return updatedStock;
    }

}
