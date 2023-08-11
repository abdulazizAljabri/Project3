package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantservice;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Merchant>> getMerchant() {
        return ResponseEntity.status(HttpStatus.OK).body(merchantservice.getMerchantList());
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> addMerchant(@RequestBody @Valid Merchant merchant) {
        var createdMerchant = merchantservice.addMerchant(merchant);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("merchant has been created", createdMerchant, HttpStatus.CREATED.value()));
    }

    @PutMapping("/{merchantId}")
    public ResponseEntity<ApiResponse> updateMerchant(@PathVariable Integer merchantId, @RequestBody @Valid Merchant merchant) {
         merchantservice.updateMerchant(merchantId, merchant);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("merchant has been updated", merchant, HttpStatus.OK.value()));
    }

    @DeleteMapping("deleteMerchant/{merchantId}")
    public ResponseEntity<ApiResponse> deleteMerchant(@PathVariable Integer merchantId) {
        boolean isDelete = merchantservice.deleteMerchant(merchantId);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong MerchantId"));
    }


    @PutMapping("/moreStock")
    public ResponseEntity<ApiResponse> addMoreStock(@RequestBody @Valid MerchantStock merchantStock) {
        merchantservice.addMoreStock(merchantStock.getProductId(), merchantStock.getMerchantId(), merchantStock.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("addMoreStock done"));
    }

}
