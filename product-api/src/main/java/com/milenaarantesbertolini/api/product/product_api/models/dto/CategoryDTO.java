package com.milenaarantesbertolini.api.product.product_api.models.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.milenaarantesbertolini.api.product.product_api.models.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class CategoryDTO {

    private String id;

    @NotBlank(message= "Nome da categoria é obrigatório")
    private String name;

    public static CategoryDTO convert(Category category){

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }

}
