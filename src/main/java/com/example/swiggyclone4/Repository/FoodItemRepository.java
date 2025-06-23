package com.example.swiggyclone4.Repository;

import com.example.swiggyclone4.Dto.FoodItemsDto;
import com.example.swiggyclone4.Entity.FoodItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FoodItemRepository extends JpaRepository<FoodItems, Long> {

    @Query("SELECT new com.example.swiggyclone4.Dto.FoodItemsDto(f.id, f.name, f.category, f.price, f.restaurants.name) " +
            "FROM FoodItems f " +
            "WHERE (:name IS NULL OR LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:category IS NULL OR f.category = :category) " +
            "AND (:restaurantId IS NULL OR f.restaurants.id = :restaurantId)")
    Page<FoodItemsDto> searchFoodItemsAsDto (@Param("name") String name,
                                             @Param("category") String category,
                                             @Param("restaurantId") Integer restaurantId
           , Pageable pageable);




}
