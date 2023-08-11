package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    private Integer merchantStockId;


    private Integer productId;


    private Integer merchantId;

    private Integer stock;


}
