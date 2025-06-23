package com.example.swiggyclone4.Service;

import com.example.swiggyclone4.Dto.FoodItemsDto;
import com.example.swiggyclone4.Repository.RestaurantFooditemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantFooditems {

    @Autowired
    private RestaurantFooditemsRepository restaurantFooditemsRepository;

    public List<FoodItemsDto> getItemsbyRestaurantId(Long restaurantId){
        return restaurantFooditemsRepository.getFooditemsforRestaurant(restaurantId);
    }
}
