package com.milenaarantesbertolini.api.product.product_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.milenaarantesbertolini.api.product.product_api.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

    List<Product> findByCategoryId(String categoryId);

    Product findByProductIdentifier(String productIdentifier);
}
