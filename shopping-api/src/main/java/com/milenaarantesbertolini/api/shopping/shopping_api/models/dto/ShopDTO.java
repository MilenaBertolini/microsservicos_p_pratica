package com.milenaarantesbertolini.api.shopping.shopping_api.models.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.Item;
import com.milenaarantesbertolini.api.shopping.shopping_api.models.Shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ShopDTO {

    private String id;

    private String userIdentifier;

    private LocalDateTime date;

    private Double total;
    
    private List<Item> itens;

    public static ShopDTO convert(Shop shop){

        ShopDTO shopDTO = new ShopDTO();

        shopDTO.setId(shop.getId());
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setDate(shop.getDate());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setItens(shop.getItens());

        return shopDTO;

    }
}
