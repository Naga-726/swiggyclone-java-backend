package com.example.swiggyclone4.Service;

import com.example.swiggyclone4.Dto.FoodItemsDto;
import com.example.swiggyclone4.Entity.FoodItems;
import com.example.swiggyclone4.Repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public Page<FoodItemsDto> searchFoodItems(String name, String category, Integer restaurantId, Pageable pageable ) {
        return foodItemRepository.searchFoodItemsAsDto(name,category,restaurantId,pageable);

    }
}
