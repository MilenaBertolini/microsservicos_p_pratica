package com.milenaarantesbertolini.api.product.product_api.models.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import com.milenaarantesbertolini.api.product.product_api.models.Category;
import com.milenaarantesbertolini.api.product.product_api.models.Product;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ProductDTO {

    private String id;

    private String productIdentifier;

    @NotBlank(message= "Nome é obrigatório")
    private String name;

    private String description;

    private Double price;

    @NotBlank(message= "Categoria é obrigatório")
    private String categoryId;

    private Category category;


    public static ProductDTO convert(Product product){

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategoryId(product.getCategoryId());
        productDTO.setCategory(product.getCategory());
        productDTO.setProductIdentifier(product.getProductIdentifier());

        return productDTO;
    }

}
