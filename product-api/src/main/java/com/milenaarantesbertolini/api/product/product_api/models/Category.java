package com.milenaarantesbertolini.api.product.product_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.milenaarantesbertolini.api.product.product_api.models.dto.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "category")
public class Category {

    @Id
    private String id;

    @Field("name")
    private String name;

    public static Category convert(CategoryDTO categoryDTO){

        Category category = new Category();

        category.setName(categoryDTO.getName());

        return category;
    }

}
