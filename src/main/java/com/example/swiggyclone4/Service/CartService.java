package com.example.swiggyclone4.Service;

import com.example.swiggyclone4.Custom.JwtService;
import com.example.swiggyclone4.Entity.Cart;
import com.example.swiggyclone4.Entity.FoodItems;
import com.example.swiggyclone4.Entity.User;
import com.example.swiggyclone4.Repository.CartRepository;
import com.example.swiggyclone4.Repository.FoodItemRepository;
import com.example.swiggyclone4.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public void addToCart(Long userId,Long foodItemId) {

        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));

        FoodItems foodItems=foodItemRepository.findById(foodItemId).orElseThrow(()->new RuntimeException("fooditems not found"));

        Cart cart=new Cart();
        cart.setUser(user);
        cart.setFoodItems(foodItems);
        cart.setQuantity(1);
        cartRepository.save(cart);



    }


    public List<Cart> getCartItems(Long userId){
        return cartRepository.findByuserId(userId);
    }
}
