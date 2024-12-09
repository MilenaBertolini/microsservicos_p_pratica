package com.milenaarantesbertolini.api.shopping.shopping_api.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.milenaarantesbertolini.api.shopping.shopping_api.models.dto.ReportDTO;
import com.milenaarantesbertolini.api.shopping.shopping_api.models.dto.ShopDTO;
import com.milenaarantesbertolini.api.shopping.shopping_api.service.ShopService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO save(@RequestBody @Valid ShopDTO shopDTO){
        
        return shopService.save(shopDTO);
    }
    
    @GetMapping
    public List<ShopDTO> getAll(){
        
        return shopService.getAll();
    }

    @GetMapping("/{id}")
    public ShopDTO findById(@PathVariable String id){

        return shopService.findById(id);
    }

    @GetMapping("/shopByUser")
    public List<ShopDTO> getShopsByUser(@RequestParam String userIdentifier){

        return shopService.getShopsByUser(userIdentifier);
    }

    @GetMapping("/shopByDate")
    public List<ShopDTO> getByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime date) {

        return shopService.getShopsByDate(date);
    }

    @GetMapping("/getByIdentifier/{productIdentifier}")
    public ShopDTO findByProductIdentifier (@PathVariable String productIdentifier) {

        return shopService.getByProductIdentifier(productIdentifier);
    }

    @GetMapping("/search")
    public List<ShopDTO> getShopsByFilter(
        @RequestParam String inicialDate, 
        @RequestParam String finalDate,
        @RequestParam Double minValue
    ) {
        LocalDateTime startDate = LocalDate.parse(inicialDate).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(finalDate).atStartOfDay();
        return shopService.getShopsByFilter(startDate, endDate, minValue);
    }
    
    @GetMapping("/shopping/report")
    public ReportDTO getReportByDate(@RequestParam String inicialDate, @RequestParam String finalDate) {

        LocalDateTime startDate = LocalDate.parse(inicialDate).atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(finalDate).atStartOfDay();

        return shopService.getReportByDate(startDate, endDate);
    }
    
    
}
