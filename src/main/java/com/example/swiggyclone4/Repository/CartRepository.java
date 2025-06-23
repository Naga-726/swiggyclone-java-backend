package com.example.swiggyclone4.Repository;

import com.example.swiggyclone4.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByuserId(Long userId);
}
