package com.milenaarantesbertolini.api.shopping.shopping_api.models.dto;

import java.util.List;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.Shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {

    private int totalShops;
    private Double totalAmount;
    private List<Shop> shops;
    
}
