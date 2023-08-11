package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantstock/")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;


    @GetMapping("getmerchantstock")
    public ArrayList<MerchantStock> getMerchantStock(){
        return merchantStockService.getMerchantStockList();
    }

    @PostMapping("addmerchantstock")
    public ResponseEntity addMerchantStock(@RequestBody MerchantStock merchantsrock) {
        merchantStockService.addMerchantStock(merchantsrock);
        return ResponseEntity.status(200).body(new ApiResponse("MerchantStock added"));
    }

    @PutMapping("updatemerchantstock/{merchantStockId}")
    public ResponseEntity updateMerchantStock(@RequestBody MerchantStock stock , @PathVariable Integer merchantStockId){
        boolean isUpdateMerchantStock = merchantStockService.updateMerchantStock(merchantStockId , stock);
        if(isUpdateMerchantStock){
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Merchant StockID"));
    }

    @DeleteMapping("deletemerchantstock/{merchantStockId}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer merchantStockId){
        boolean isDelete = merchantStockService.deleteMerchantStock(merchantStockId);
        if (isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock is deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Merchant StockID"));
    }


}
