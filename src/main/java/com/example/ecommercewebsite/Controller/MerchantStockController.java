package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/merchantstock/")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;


    @GetMapping("getmerchantstock")
    public List<MerchantStock> getMerchantStock() {
        return merchantStockService.findAll();
    }

    @PostMapping("addmerchantstock")
    public ResponseEntity<ApiResponse> addMerchantStock(@RequestBody MerchantStock merchantstock) {
        merchantStockService.add(merchantstock);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("merchantStock has been updated", merchantstock, HttpStatus.OK.value()));
    }

    @PutMapping("updatemerchantstock/{merchantStockId}")
    public ResponseEntity updateMerchantStock(@RequestBody MerchantStock stock, @PathVariable Integer merchantStockId) {
        merchantStockService.update(merchantStockId, stock);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("merchantStock has been updated", merchantStockId, HttpStatus.OK.value()));
    }

    @DeleteMapping("deletemerchantstock/{merchantStockId}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer merchantStockId) {
        merchantStockService.removeById(merchantStockId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("merchantStock has been deleted", merchantStockId, HttpStatus.OK.value()));
    }


}
