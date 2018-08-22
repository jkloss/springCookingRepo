package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPizza {
    private Pizza pizza = new Pizza(20.0, 40, "hawajska", true);

    @GetMapping("/showname")
    public String showPizza() {
        return pizza.getName();
    }


}
