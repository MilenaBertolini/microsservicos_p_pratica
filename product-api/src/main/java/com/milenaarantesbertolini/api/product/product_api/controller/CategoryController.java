package com.milenaarantesbertolini.api.product.product_api.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.milenaarantesbertolini.api.product.product_api.models.dto.CategoryDTO;
import com.milenaarantesbertolini.api.product.product_api.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO newCategory(@RequestBody @Valid CategoryDTO categoryDTO){

        return categoryService.save(categoryDTO);
    }

    @PatchMapping("/{id}")
    public CategoryDTO editCategory(@PathVariable String id, @RequestBody CategoryDTO categoryDTO){
        
        return categoryService.edit(id, categoryDTO);
    }

    @GetMapping
    public List<CategoryDTO> getCategories(){
        
        return categoryService.getAll();
    }

    @GetMapping("/pageable")
    public Page<CategoryDTO> getAllPage(Pageable pageable){
        
        return categoryService.getAllPage(pageable);
    }

    @DeleteMapping("/{id}")
    public CategoryDTO delete(@PathVariable String id){

        return categoryService.delete(id);
    }

}
