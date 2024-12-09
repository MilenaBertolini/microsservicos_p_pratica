package com.milenaarantesbertolini.api.shopping.shopping_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.Shop;

import java.time.LocalDateTime;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String>{

    List<Shop> findByUserIdentifier(String userIdentifier);

    List<Shop> findByDate(LocalDateTime date);

    @Query("{ 'itens.productIdentifier': ?0 }")
    Shop findByItemProductIdentifier(String productIdentifier);

    @Query("{ 'date': { $gte: ?0, $lte: ?1 }, 'total': { $gte: ?2 } }")
    List<Shop> findByDateAndTotalBetween(LocalDateTime inicialDate, LocalDateTime finalDate, Double minValue);

    @Query("{ 'date': { $gte: ?0, $lte: ?1 } }")
    List<Shop> findByDateBetween(LocalDateTime inicialDate, LocalDateTime finalDate);
}
