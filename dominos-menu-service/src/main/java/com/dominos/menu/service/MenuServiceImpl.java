package com.dominos.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominos.menu.entity.Menu;
import com.dominos.menu.exception.custom.MenuNotFoundException;
import com.dominos.menu.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public Menu addMenu(Menu menu) {
        return repository.save(menu);
    }

    @Override
    public List<Menu> getMenuByRestaurant(Long restaurantId) {
        return repository.findByRestaurantId(restaurantId);
    }

    @Override
    public Menu getMenuById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new MenuNotFoundException("Menu not found with id " + id));
    }

    @Override
    public Menu updateMenu(Long id, Menu menu) {
        Menu existing = getMenuById(id);
        existing.setItemName(menu.getItemName());
        existing.setCategory(menu.getCategory());
        existing.setPrice(menu.getPrice());
        existing.setOffer(menu.getOffer());
        existing.setAvailable(menu.isAvailable());
        return repository.save(existing);
    }

    @Override
    public void deleteMenu(Long id) {
        repository.delete(getMenuById(id));
    }
}
