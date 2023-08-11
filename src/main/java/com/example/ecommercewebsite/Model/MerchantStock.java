package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MerchantStock {

    private Integer merchantStockId;


    @NotNull(message = "product id is required")
    private Integer productId;

    @NotNull(message = "merchant id is required")
    private Integer merchantId;

    @NotNull(message = "stock is required")
        private Integer stock;


}
