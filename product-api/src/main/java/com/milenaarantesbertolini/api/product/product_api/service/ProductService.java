package com.milenaarantesbertolini.api.product.product_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.milenaarantesbertolini.api.product.product_api.models.Category;
import com.milenaarantesbertolini.api.product.product_api.models.Product;
import com.milenaarantesbertolini.api.product.product_api.models.dto.ProductDTO;
import com.milenaarantesbertolini.api.product.product_api.repository.CategoryRepository;
import com.milenaarantesbertolini.api.product.product_api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductDTO save(ProductDTO productDTO){

        Category category = categoryRepository
            .findById(productDTO.getCategoryId())
            .orElseThrow(() -> new RuntimeException());

        productDTO.setCategory(category);

        Product product = productRepository.save(Product.convert(productDTO));

        return ProductDTO.convert(product);
    }

    public ProductDTO edit(String productId, ProductDTO productDTO){

        Product product = productRepository
            .findById(productId)
            .orElseThrow(() -> new RuntimeException());

        if(
            productDTO.getName() != null && 
            !product.getName().equals(productDTO.getName())
        ){
            product.setName(productDTO.getName());
        }

        if(
            productDTO.getDescription() != null && 
            !product.getDescription().equals(productDTO.getDescription())
        ){
            product.setDescription(productDTO.getDescription());
        }

        if(
            productDTO.getPrice() != null && 
            !product.getPrice().equals(productDTO.getPrice())
        ){
            product.setPrice(productDTO.getPrice());
        }

        if(
            productDTO.getCategoryId() != null &&
            !product.getCategoryId().equals(productDTO.getCategoryId())
        ){
            product.setCategoryId(productDTO.getCategoryId());

            Category category = categoryRepository
                .findById(product.getCategoryId())
                .orElseThrow(() -> new RuntimeException());

            product.setCategory(category);
        }
        
        product = productRepository.save(product);
        return ProductDTO.convert(product);
        
    }

    public ProductDTO findById(String producId){

        Product product = productRepository
            .findById(producId)
            .orElseThrow(() -> new RuntimeException("Product not found!"));

        return ProductDTO.convert(product);

    }
    
    public List<ProductDTO> getAll(){

        List<Product> products = productRepository.findAll();

        return products
            .stream()
            .map(ProductDTO::convert)
            .collect(Collectors.toList());
    }

    public Page<ProductDTO> getAllPage(Pageable page){

        Page<Product> products = productRepository.findAll(page);

        return products.map(ProductDTO::convert);
    }

    public List<ProductDTO> getProductsByCategoryId(String categoryId){

        List<Product> products = productRepository.findByCategoryId(categoryId);

        return products
            .stream()
            .map(ProductDTO::convert)
            .collect(Collectors.toList());

    }

    public ProductDTO findByProductIdentifier(String productIdentifier){

        Product product = productRepository.findByProductIdentifier(productIdentifier);

        if(product != null){

            return ProductDTO.convert(product);
        }

        return null;
        
    }

    public ProductDTO delete(String productId){

        Product product = productRepository
            .findById(productId)
            .orElseThrow(() -> new RuntimeException());

        productRepository.delete(product);

        return ProductDTO.convert(product); 
    }

}
