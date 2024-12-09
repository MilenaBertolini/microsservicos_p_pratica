package com.milenaarantesbertolini.api.shopping.shopping_api.models.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ItemDTO {

    private String productIdentifier;

    private Double price;

    public static ItemDTO convert(Item item){

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());

        return itemDTO;
    }


}
