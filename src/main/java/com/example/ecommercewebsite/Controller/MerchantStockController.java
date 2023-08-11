package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse> addMerchantStock(@RequestBody MerchantStock merchantstock) {
        merchantStockService.addMerchantStock(merchantstock);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("merchantStock has been updated", merchantstock, HttpStatus.OK.value()));
    }

    @PutMapping("updatemerchantstock/{merchantStockId}")
    public ResponseEntity updateMerchantStock(@RequestBody MerchantStock stock , @PathVariable Integer merchantStockId){
        boolean isUpdateMerchantStock = merchantStockService.updateMerchantStock(merchantStockId , stock);
        if(isUpdateMerchantStock){
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("merchantStock has been updated", merchantStockId, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Merchant StockID"));
    }

    @DeleteMapping("deletemerchantstock/{merchantStockId}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer merchantStockId){
        boolean isDelete = merchantStockService.deleteMerchantStock(merchantStockId);
        if (isDelete){
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("merchantStock has been deleted", merchantStockId, HttpStatus.OK.value()));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Merchant StockID"));
    }


}
