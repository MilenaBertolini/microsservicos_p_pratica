package com.milenaarantesbertolini.api.shopping.shopping_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.Item;
import com.milenaarantesbertolini.api.shopping.shopping_api.models.Shop;
import com.milenaarantesbertolini.api.shopping.shopping_api.models.dto.ReportDTO;
import com.milenaarantesbertolini.api.shopping.shopping_api.models.dto.ShopDTO;
import com.milenaarantesbertolini.api.shopping.shopping_api.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopDTO save(ShopDTO shopDTO){

        Double totalPrice = shopDTO
                              .getItens()
                              .stream()
                              .mapToDouble(Item::getPrice)
                              .sum();

        shopDTO.setTotal(totalPrice);

        Shop shop = shopRepository.save(Shop.convert(shopDTO));
        
        return ShopDTO.convert(shop);

    }

    public ShopDTO findById(String id){

        Shop shop = shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found!"));

        return ShopDTO.convert(shop);
    }

    public List<ShopDTO> getAll(){
        
        List<Shop> shops = shopRepository.findAll();

        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public List<ShopDTO> getShopsByUser(String userIdentifer){

        List<Shop> shops = shopRepository.findByUserIdentifier(userIdentifer);

        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());

    }

    public List<ShopDTO> getShopsByDate(LocalDateTime date){
        
        List<Shop> shops = shopRepository.findByDate(date);

        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public ShopDTO getByProductIdentifier(String productIdentifier){

        Shop shop = shopRepository.findByItemProductIdentifier(productIdentifier);

        if(shop != null){

            return ShopDTO.convert(shop);
        }

        return null;

    }

    public List<ShopDTO> getShopsByFilter(LocalDateTime inicialDate, LocalDateTime finalDate, Double minValue){

        List<Shop> shops = shopRepository.findByDateAndTotalBetween(inicialDate, finalDate, minValue);

        return shops
            .stream()
            .map(ShopDTO::convert)
            .collect(Collectors.toList());
    }

    public ReportDTO getReportByDate(LocalDateTime inicialDate, LocalDateTime finalDate){

        List<Shop> shops = shopRepository.findByDateBetween(inicialDate, finalDate);

        int totalShops = shops.size();
        Double totalAmount = shops
                                .stream()
                                .mapToDouble(Shop::getTotal)
                                .sum();

        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setTotalShops(totalShops);
        reportDTO.setTotalAmount(totalAmount);
        reportDTO.setShops(shops);

        return reportDTO;
    }

}
