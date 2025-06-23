package com.example.swiggyclone4.Service;

import com.example.swiggyclone4.Dto.RestaurantDto;
import com.example.swiggyclone4.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDto> getAllRestaurants(){
        return restaurantRepository.findAll()
                .stream()
                .map(r->new RestaurantDto(r.getId(),r.getName(),r.getLocation()))
                .collect(Collectors.toList());
    }
}
