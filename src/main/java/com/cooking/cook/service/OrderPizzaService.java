package com.cooking.cook.service;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.repositories.PizzaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderPizzaService  {

    private PizzaRepository pizzaRepository;
    public OrderPizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzaList() {
        return pizzaRepository.findAll();
    }

    public void createPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }
}
