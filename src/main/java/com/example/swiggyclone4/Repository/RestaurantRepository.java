package com.example.swiggyclone4.Repository;

import com.example.swiggyclone4.Dto.RestaurantDto;
import com.example.swiggyclone4.Entity.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants,Long> {


}
