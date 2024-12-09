package com.milenaarantesbertolini.api.product.product_api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.milenaarantesbertolini.api.product.product_api.models.dto.ProductDTO;
import com.milenaarantesbertolini.api.product.product_api.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO newProduct(@RequestBody @Valid ProductDTO productDTO){

        return productService.save(productDTO);
    }

    // @PatchMapping("/{id}")
    @PatchMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ProductDTO editProduct(@PathVariable String id, @RequestBody ProductDTO productDTO){
        
        return productService.edit(id, productDTO);
    }

    @GetMapping
    public List<ProductDTO> getProducts(){
        
        return productService.getAll();
    }

    // @GetMapping("/{id}")
    @GetMapping(value = "/getbyid/{id}", produces = "application/json")
    public ProductDTO findById(@PathVariable String id){

        return productService.findById(id);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> getAllPage(Pageable pageable){
        
        return productService.getAllPage(pageable);
    }

    @GetMapping(value = "/category/{categoryId}", produces = "application/json")
    public List<ProductDTO> getProductByCategoryId(@PathVariable String categoryId){

        return productService.getProductsByCategoryId(categoryId);
    }

    @GetMapping("/getidentifier/{productIdentifier}")
    public ProductDTO getProductByProductIdentifier(@PathVariable String productIdentifier){

        return productService.findByProductIdentifier(productIdentifier);
    }
    

    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable String id){

        return productService.delete(id);
    }
}
