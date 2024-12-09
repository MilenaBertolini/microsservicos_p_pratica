package com.milenaarantesbertolini.api.shopping.shopping_api.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.dto.ShopDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "shop")
public class Shop {

    @Id
    private String id;

    @Field("userIdentifier")
    private String userIdentifier;

    @Field("date")
    private LocalDateTime date;

    @Field("total")
    private Double total;
    
    private List<Item> itens;

    public Shop() {
        this.userIdentifier = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
    }

    public static Shop convert(ShopDTO shopDTO){

        Shop shop = new Shop();

        shop.setTotal(shopDTO.getTotal());
        shop.setItens(shopDTO.getItens());

        return shop;
    }
}
