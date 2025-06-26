# Swiggy Clone - Java Backend

This is a backend clone of Swiggy built using Java and Spring Boot.

## Features
- User registration & login
- Restaurant listing
- Cart & order management
- JWT-based authentication

## Tech Stack
- Java 17
- Spring Boot
- MySQL
- JPA / Hibernate
- Maven

##Project Structure
+---.settings
|       org.eclipse.core.resources.prefs
|       org.eclipse.jdt.core.prefs
|
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---example
|   |   |           \---swiggyclone4
|   |   |               |   SwiggyClone4Application.java
|   |   |               |
|   |   |               +---Controller
|   |   |               |       UserController.java
|   |   |               |
|   |   |               +---Custom
|   |   |               |       JwtService.java
|   |   |               |
|   |   |               +---Dto
|   |   |               |       AuthResponse.java
|   |   |               |       FoodItemesByPriceDto.java
|   |   |               |       FoodItemsDto.java
|   |   |               |       RestaurantDto.java
|   |   |               |       SigninRequest.java
|   |   |               |       SignupRequest.java
|   |   |               |
|   |   |               +---Entity
|   |   |               |       Cart.java
|   |   |               |       FoodItems.java
|   |   |               |       Restaurants.java
|   |   |               |       Role.java
|   |   |               |       User.java
|   |   |               |
|   |   |               +---JwtConfiguration
|   |   |               |       Jwtfilter.java
|   |   |               |
|   |   |               +---Repository
|   |   |               |       CartRepository.java
|   |   |               |       FoodItemRepository.java
|   |   |               |       PriceRepository.java
|   |   |               |       RestaurantFooditemsRepository.java
|   |   |               |       RestaurantRepository.java
|   |   |               |       UserRepository.java
|   |   |               |
|   |   |               +---SecurityConfiguration
|   |   |               |       SecurityConfig.java
|   |   |               |
|   |   |               \---Service
|   |   |                       AuthService.java
|   |   |                       CartService.java
|   |   |                       CustomuserDetailsService.java
|   |   |                       FoodItemService.java
|   |   |                       FoodItemServiceByPrice.java
|   |   |                       RestaurantFooditems.java
|   |   |                       RestaurantService.java
|   |   |                       SigninService.java
|   |   |
|   |   \---resources
|   |       |   application.properties
|   |       |
|   |       +---static
|   |       \---templates

## Getting Started

1. Clone the repo:
```bash
git clone https://github.com/Naga-726/swiggyclone-java-backend.git
