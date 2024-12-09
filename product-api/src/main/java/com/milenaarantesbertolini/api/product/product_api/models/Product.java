package com.milenaarantesbertolini.api.product.product_api.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.milenaarantesbertolini.api.product.product_api.models.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    @Field("productIdentifier")
    private String productIdentifier;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("price")
    private Double price;

    @Field("category_id")
    private String categoryId;

    @DBRef
    private Category category;

    public Product() {
        this.productIdentifier = UUID.randomUUID().toString();
    }

    public static Product convert(ProductDTO productDTO){

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategoryId(productDTO.getCategoryId());
        product.setCategory(productDTO.getCategory());

        return product;

    }

}
