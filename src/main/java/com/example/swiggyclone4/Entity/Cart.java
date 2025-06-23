package com.example.swiggyclone4.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private FoodItems foodItems;

    private int quantity;
}
