package com.milenaarantesbertolini.api.shopping.shopping_api.models;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.dto.ItemDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "shop")
public class Item {

    @Field("productIdentifier")
    private String productIdentifier;

    @Field("price")
    private Double price;

    public Item() {
        this.productIdentifier = UUID.randomUUID().toString();
    }

    public static Item convert(ItemDTO itemDTO){

        Item item = new Item();

        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());

        return item;
    }


}
