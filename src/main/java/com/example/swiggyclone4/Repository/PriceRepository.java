package com.example.swiggyclone4.Repository;

import com.example.swiggyclone4.Dto.FoodItemesByPriceDto;
import com.example.swiggyclone4.Entity.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<FoodItems, Long> {

    @Query("SELECT new com.example.swiggyclone4.Dto.FoodItemesByPriceDto(f.name, f.price, r.name) FROM FoodItems f JOIN f.restaurants r WHERE f.price <= :price")
    List<FoodItemesByPriceDto> findByPriceLessThan(@Param("price") double price);
}
