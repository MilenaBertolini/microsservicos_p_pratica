package com.milenaarantesbertolini.api.product.product_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.milenaarantesbertolini.api.product.product_api.models.Category;
import com.milenaarantesbertolini.api.product.product_api.models.dto.CategoryDTO;
import com.milenaarantesbertolini.api.product.product_api.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDTO save(CategoryDTO categoryDTO){

        Category category = categoryRepository.save(Category.convert(categoryDTO));

        return CategoryDTO.convert(category);
    }

    public CategoryDTO edit(String categoryId, CategoryDTO categoryDTO){

        Category category = categoryRepository
            .findById(categoryId)
            .orElseThrow(() -> new RuntimeException());

        if(
            categoryDTO.getName() != null && 
            !category.getName().equals(categoryDTO.getName())
        ){
            category.setName(categoryDTO.getName());
        }

        category = categoryRepository.save(category);
        return CategoryDTO.convert(category);
    }

    public List<CategoryDTO> getAll(){

        List<Category> categories = categoryRepository.findAll();

        return categories
            .stream()
            .map(CategoryDTO::convert)
            .collect(Collectors.toList());
    }

    public Page<CategoryDTO> getAllPage(Pageable page){

        Page<Category> categories = categoryRepository.findAll(page);

        return categories.map(CategoryDTO::convert);
    }

    public CategoryDTO delete(String categoryId){

        Category category = categoryRepository
            .findById(categoryId)
            .orElseThrow(() -> new RuntimeException());

        categoryRepository.delete(category);

        return CategoryDTO.convert(category);
    }

}
