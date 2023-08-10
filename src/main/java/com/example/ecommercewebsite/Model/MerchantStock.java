package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "should not be empty")
    private Integer merchantStockId;

    @NotEmpty(message = "should not be empty")
    private Integer productId;

    @NotEmpty(message = "should not be empty")
    private Integer merchantId;

    @NotEmpty(message = "should not be empty")
    @Size(min = 10,message = "should be more then 10")
    private Integer stock;


}
