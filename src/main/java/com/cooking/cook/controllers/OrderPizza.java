package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.data.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
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
       restaurant.getMenu().add(new Pizza(20.0, 40, "hawajska"));
       restaurant.getMenu().add(new Pizza(24.0, 30, "kebab"));
       restaurant.getMenu().add(new Pizza(26.0, 40, "egrerg"));
       restaurant.getMenu().add(new Pizza(28.0, 30, "greegr"));
       restaurant.getMenu().add(new Pizza(24.0, 30, "bgfdb"));
       restaurant.getMenu().add(new Pizza(12.0, 30, "tyj"));
       restaurant.getMenu().add(new Pizza(30.0, 40, "qwdwq"));
       restaurant.getMenu().add(new Pizza(17.0, 30, "vsdd"));
       restaurant.getMenu().add(new Pizza(21.0, 30, "lui"));
       restaurant.getMenu().add(new Pizza(22.5, 50, "wev"));
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
    public List<String> sortPizzaNames() {
        return restaurant.getMenu().stream()
                .map(Pizza::getName)
                .sorted()
                .collect(toList());
    }

    @GetMapping("/choosePizzaStartsWith/{letter}")
    public List<Pizza> choosePizzaStartsWith(@PathVariable String letter) {
        return restaurant.getMenu().stream()
                .filter(pizza -> pizza.getName().startsWith(letter))
                .collect(toList());
    }

    @GetMapping("/choosePizzaUnder40Diam")
    public List<Pizza> choosePizzaUnder40Diam() {
        return restaurant.getMenu().stream()
                .filter(pizza -> pizza.getDiameter() < 40)
                .collect(toList());
    }

    @GetMapping("/chooseTheCheapestPizza")
    public Pizza chooseTheCheapestPizza() {
        return restaurant.getMenu().stream()
                .min(Comparator.comparingDouble(Pizza::getPrice))
                .orElse(null);
    }
}
