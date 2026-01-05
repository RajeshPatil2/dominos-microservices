package com.dominos.menu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominos.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRestaurantId(Long restaurantId);
}
