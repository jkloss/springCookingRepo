package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.data.Restaurant;
import org.springframework.web.bind.annotation.*;

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
       restaurant.getMenu().add(new Pizza(26.0, 40, "egrerg", true));
       restaurant.getMenu().add(new Pizza(28.0, 30, "greegr", true));
       restaurant.getMenu().add(new Pizza(24.0, 30, "bgfdb", true));
       restaurant.getMenu().add(new Pizza(12.0, 30, "tyj", true));
       restaurant.getMenu().add(new Pizza(30.0, 40, "qwdwq", true));
       restaurant.getMenu().add(new Pizza(17.0, 30, "vsdd", true));
       restaurant.getMenu().add(new Pizza(21.0, 30, "lui", true));
       restaurant.getMenu().add(new Pizza(22.5, 50, "wev", true));
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

    @GetMapping("/sortNames")
    public 
}
