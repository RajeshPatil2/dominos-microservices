package com.dominos.restaurant.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dominos.restaurant.entity.Restaurant;
import com.dominos.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Add restaurant
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(
            @Valid @RequestBody Restaurant restaurant) {

        return ResponseEntity.ok(restaurantService.addRestaurant(restaurant));
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    // Get all restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }
    
    // Get restaurants by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Restaurant>> getByCity(@PathVariable String city) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByCity(city));
    }
}
