package com.example.swiggyclone4.Repository;

import com.example.swiggyclone4.Dto.FoodItemsDto;
import com.example.swiggyclone4.Entity.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantFooditemsRepository extends JpaRepository<FoodItems,Long> {

    @Query("SELECT new com.example.swiggyclone4.Dto.FoodItemesByPriceDto(f.name, f.price) FROM FoodItems f WHERE f.restaurant.id <= :restaurantId")
    List<FoodItemsDto> getFooditemsforRestaurant(@Param("restaurantId")Long restaurantId);
}
