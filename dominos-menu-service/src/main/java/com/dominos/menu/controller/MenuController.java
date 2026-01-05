package com.dominos.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dominos.menu.entity.Menu;
import com.dominos.menu.service.MenuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService service;

    @PostMapping
    public ResponseEntity<Menu> addMenu(@Valid @RequestBody Menu menu) {
        return ResponseEntity.ok(service.addMenu(menu));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Menu>> getByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(service.getMenuByRestaurant(restaurantId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getMenuById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(
            @PathVariable Long id,
            @Valid @RequestBody Menu menu) {
        return ResponseEntity.ok(service.updateMenu(id, menu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteMenu(id);
        return ResponseEntity.ok("Menu deleted successfully");
    }
}
