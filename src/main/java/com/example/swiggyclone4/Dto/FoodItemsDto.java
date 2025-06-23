package com.example.swiggyclone4.Dto;

import lombok.Data;

@Data
public class FoodItemsDto {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private String restaurantName;

    public FoodItemsDto(Long id, String name, String category, Double price, String restaurantName) {
        this.id  = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.restaurantName = restaurantName;

    }
}
