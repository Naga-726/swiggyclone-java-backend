package com.example.swiggyclone4.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "food_items")
public class FoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private Double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurants restaurants;



}
