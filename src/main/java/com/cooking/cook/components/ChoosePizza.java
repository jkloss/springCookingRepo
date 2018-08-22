package com.cooking.cook.components;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.data.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ChoosePizza {

    private Restaurant restaurant;
    public ChoosePizza(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Pizza> getChoosenPizza(String name) {

        return restaurant.getMenu().stream()
                .filter(pizza -> pizza.getName().equals(name))
                .collect(toList());
    }
}
