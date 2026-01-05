package com.dominos.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominos.restaurant.entity.Restaurant;
import com.dominos.restaurant.exception.custom.RestaurantNotFoundException;
import com.dominos.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() ->
                        new RestaurantNotFoundException("Restaurant not found with id " + id));
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        List<Restaurant> restaurants = restaurantRepository.findByCity(city);

        if (restaurants.isEmpty()) {
            throw new RestaurantNotFoundException(
                    "No restaurants found in city: " + city);
        }
        return restaurants;
    }
}
