package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.data.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class OrderPizza {

    private Restaurant restaurant;
    public OrderPizza(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @GetMapping("/addPizza")
    public void addPizza() {
       restaurant.getMenu().add(new Pizza(20.0, 40, "hawajska", true));
       restaurant.getMenu().add(new Pizza(24.0, 30, "kebab", true));
    }

    @GetMapping("/showMenu")
    public List<Pizza> showMenu() {
        return restaurant.getMenu();
    }

    @GetMapping("/showOrder/{name}")
    public List<Pizza> showOrder(@PathVariable String name) {
        return restaurant.getMenu().stream()
                .filter(pizza -> pizza.getName().equals(name))
                .collect(toList());
    }
}
