package com.cooking.cook.controllers;

import com.cooking.cook.model.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaRestController {

    private PizzaService pizzaService;
    public PizzaRestController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizza/all")
    public List<Pizza> getAllPizza() {
        return pizzaService.getPizzaList();
    }

    @GetMapping("/pizza/{name}")
    public Pizza getPizzaWithGivenName(@PathVariable(value = "name") String name) {
        return pizzaService.getPizzaWithGivenName(name);
    }

    @GetMapping("/pizza/{number}")
    public List<Pizza> getPizzaGreaterThanGivenNumber(@PathVariable(value = "number") String number) {
        return pizzaService.getPizzaWhichIsGreaterThanGivenNumber(Integer.parseInt(number));
    }

}
