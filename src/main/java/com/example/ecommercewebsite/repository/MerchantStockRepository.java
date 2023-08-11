package com.example.ecommercewebsite.repository;

import com.example.ecommercewebsite.Model.MerchantStock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MerchantStockRepository {
    private final List<MerchantStock> stockList = new ArrayList<>();

    public List<MerchantStock> findAll(){
        return this.stockList;
    }
    public void add(MerchantStock stock){
        stockList.add(stock);
    }

    public MerchantStock findById(Integer id){
        return stockList.stream().filter(stock -> stock.getMerchantStockId().equals(id)).findFirst().orElseThrow();
    }
    public void removeById(Integer id) {
        var user = findById(id);
        stockList.remove(user);
    }
    public MerchantStock update(MerchantStock stock) {
        var updatedStock = findById(stock.getMerchantStockId());
        updatedStock.setProductId(stock.getProductId());
        updatedStock.setStock(stock.getStock());
        updatedStock.setMerchantId(stock.getMerchantId());
        return updatedStock;
    }

}
