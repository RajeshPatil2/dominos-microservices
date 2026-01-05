package com.dominos.restaurant.service;

import java.util.List;

import com.dominos.restaurant.entity.Restaurant;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(Long id);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantsByCity(String city);
}
