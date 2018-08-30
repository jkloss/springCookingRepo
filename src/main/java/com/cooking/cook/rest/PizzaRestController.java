package com.cooking.cook.rest;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaRestController {

    private PizzaService pizzaService;
    public PizzaRestController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/showMenu")
    public List<Pizza> showMenu() {
        return pizzaService.getPizzaList();
    }
    
}
