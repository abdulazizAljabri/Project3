package com.example.ecommercewebsite.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "should not be empty")
    private Integer merchantStockId;

    @NotNull(message = "should not be empty")
    private Integer productId;

    @NotNull(message = "should not be empty")
    private Integer merchantId;

    @NotNull(message = "should not be empty")
    @Size(min = 10,message = "should be more then 10")
    private Integer stock;


}
