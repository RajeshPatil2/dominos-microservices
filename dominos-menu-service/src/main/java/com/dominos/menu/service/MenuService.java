package com.dominos.menu.service;

import java.util.List;

import com.dominos.menu.entity.Menu;

public interface MenuService {

    Menu addMenu(Menu menu);

    List<Menu> getMenuByRestaurant(Long restaurantId);

    Menu getMenuById(Long id);

    Menu updateMenu(Long id, Menu menu);

    void deleteMenu(Long id);
}
