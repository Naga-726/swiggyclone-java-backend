package com.example.swiggyclone4.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemesByPriceDto {

    private String name;
    private double price;
    private String restaurantName;


}
