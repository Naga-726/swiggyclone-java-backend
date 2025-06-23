package com.example.swiggyclone4.Service;

import com.example.swiggyclone4.Dto.FoodItemesByPriceDto;
import com.example.swiggyclone4.Entity.FoodItems;
import com.example.swiggyclone4.Repository.FoodItemRepository;
import com.example.swiggyclone4.Repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemServiceByPrice {

    @Autowired
    private PriceRepository priceRepository;


    public List<FoodItemesByPriceDto> findByPrice(double price){

        return priceRepository.findByPriceLessThan(price);
    }
}
 /*  public List<FoodItems> FoodItemServiceByPrice2() {
       return priceRepository.findByPriceLessThan(200.0);
   }
   public List<FoodItems> FoodItemServiceByPrice3() {
       return priceRepository.findByPriceLessThan(300.0);
   }
   public List<FoodItems> FoodItemServiceByPrice4() {
       return priceRepository.findByPriceLessThan(400.0);
   }
}*/
