package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.repository.MerchantStockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantstockrepository;

    public ArrayList<MerchantStock> getMerchantStockList() {
        return this.merchantstockrepository.getAll();
    }
    public void addMerchantStock(MerchantStock stock) {
        merchantstockrepository.addStock(stock);
    }

    public MerchantStock updateMerchantStock( Integer merchantStockId ,MerchantStock stock){
        try{
            var updateMerchantStock = merchantstockrepository.getAll().stream().filter(m -> m.getMerchantStockId().equals(merchantStockId)).findFirst().orElseThrow();
            updateMerchantStock.setProductId(stock.getProductId());
            updateMerchantStock.setMerchantId(stock.getMerchantId());
            updateMerchantStock.setStock(stock.getStock());
        }catch (NoSuchElementException exception){
            throw new NotFoundException("MerchantStock ID" + merchantStockId + "not found");
        }
        return merchantstockrepository.update(stock);

    }
    public void deleteMerchantStock(Integer merchantStockId){
        merchantstockrepository.removeById(merchantStockId);
    }

}
