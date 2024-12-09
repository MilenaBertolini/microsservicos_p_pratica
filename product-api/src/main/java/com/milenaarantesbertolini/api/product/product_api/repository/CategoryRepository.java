package com.milenaarantesbertolini.api.product.product_api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.milenaarantesbertolini.api.product.product_api.models.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{

}
