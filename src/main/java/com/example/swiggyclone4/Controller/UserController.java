package com.example.swiggyclone4.Controller;

import com.example.swiggyclone4.Custom.JwtService;
import com.example.swiggyclone4.Dto.*;
import com.example.swiggyclone4.Entity.Cart;
import com.example.swiggyclone4.Entity.FoodItems;
import com.example.swiggyclone4.JwtConfiguration.Jwtfilter;
import com.example.swiggyclone4.Repository.RestaurantFooditemsRepository;
import com.example.swiggyclone4.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private SigninService signinService;

    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private FoodItemServiceByPrice foodItemServiceByPrice;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantFooditems restaurantFooditems;

    @Autowired
    private CartService cartService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(authService.authenticate(signupRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody SigninRequest signinRequest) {
        return ResponseEntity.ok(signinService.signin(signinRequest));
    }

    @GetMapping("/search")
    public Page<FoodItemsDto> searchFoodItems(@RequestParam (required = false) String name,@RequestParam(required = false) String category,@RequestParam(required = false) Integer restaurantId,@PageableDefault(size = 10,sort = "name") Pageable pageable) {
        return foodItemService.searchFoodItems(name,category,restaurantId,pageable);
    }

    @GetMapping("/price")
    public List<FoodItemesByPriceDto> foodItemsByPrice(){
        return foodItemServiceByPrice.findByPrice(100);
    }

    @GetMapping("/price1")
    public List<FoodItemesByPriceDto> foodItemsByPrice1(){
        return foodItemServiceByPrice.findByPrice(200);
    }

    @GetMapping("/price2")
    public List<FoodItemesByPriceDto> foodItemsByPrice2(){
        return foodItemServiceByPrice.findByPrice(300);
    }
    @GetMapping("/price3")
    public List<FoodItemesByPriceDto> foodItemsByPrice3(){
        return foodItemServiceByPrice.findByPrice(400);
    }

    @GetMapping("/restaurantlist")
    public List<RestaurantDto> restaurantDtoList(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurantfooditems/{id}")
    public List<FoodItemsDto> allfooditems(@PathVariable Long id){
        return restaurantFooditems.getItemsbyRestaurantId(id);
    }

    public ResponseEntity<String> addToCart(@RequestParam Long foodItemId,@RequestHeader("Authorization") String token){
        Long userId=jwtService.extractUserId(token);
        cartService.addToCart(userId,foodItemId);
        return ResponseEntity.ok("Added to Cart");
    }
    @RequestMapping("/cartitems")
    public List<Cart> viewCart(@RequestHeader("Authorization") String token){
        Long userId= jwtService.extractUserId(token);
        return cartService.getCartItems(userId);
    }
}




