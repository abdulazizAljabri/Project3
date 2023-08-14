package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.MerchantStock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MerchantStockService {

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
    public MerchantStock update(Integer id , MerchantStock stock) {
        var updatedStock = findById(stock.getMerchantStockId());
        updatedStock.setProductId(stock.getProductId());
        updatedStock.setStock(stock.getStock());
        updatedStock.setMerchantId(stock.getMerchantId());
        return updatedStock;
    }

    public void addMoreStock(Integer id , Integer merchantId , int amount ){
        for(int index = 0 ; index < stockList.size(); index++){
            if(stockList.get(index).equals(id) && stockList.get(index).equals(merchantId)){

            }
        }
    }

}
