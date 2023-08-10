package com.example.ecommercewebsite.Controller;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Service.MerchantService;
import com.example.ecommercewebsite.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant/")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantservice;
    private final MerchantStockService merchantstockservice;

    @GetMapping("getmerchant")
   public ArrayList<Merchant> getMerchant(){
        return merchantservice.getMerchantList();
    }
    @PostMapping("addmerchant")
    public ResponseEntity addMerchant(@RequestBody @Valid  Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String errormessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errormessage);
        }
        merchantservice.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("merchant added"));
    }

    @PutMapping("updatemerchant/{merchantId}")
    public ResponseEntity updatemerchant( @PathVariable Integer merchantId,@RequestBody @Valid Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            String errormessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errormessage);
        }
        boolean isUpdatemerchant = merchantservice.updateMerchant(merchantId,merchant);
        if(isUpdatemerchant){
            merchantservice.updateMerchant(merchantId,merchant);
            return ResponseEntity.status(200).body(new ApiResponse("Merchant updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Merchant"));
    }

   @DeleteMapping("deleteMerchant/{merchant}")
    public ResponseEntity deleteMerchant(@PathVariable Integer merchantId){
        boolean isDelete = merchantservice.deleteMerchant(merchantId);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong MerchantId"));
    }



}
