package com.cooking.cook.service;

import com.cooking.cook.model.Pizza;
import com.cooking.cook.repositories.PizzaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PizzaService {

    private PizzaRepository pizzaRepository;
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzaList() {
        return pizzaRepository.findAll();
    }

    public void createPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public Pizza getPizzaWithGivenName(String name) {
        return pizzaRepository.findAllByNameEquals(name);
    }

    public List<Pizza> getPizzaWhichIsGreaterThanGivenNumber(Integer number) {
        return pizzaRepository.findAll().stream()
                .filter(pizza -> pizza.getDiameter() >= number)
                .collect(toList());
    }

    public void deleteRecord(Long id) {
        pizzaRepository.deleteById(id);
    }

    public double getPizzaPriceAvg() {
        return pizzaRepository.getPizzaPriceAvg();
    }

    public double getPizzaPriceSum() {
        return pizzaRepository.getPizzaPriceSum();
    }

    public List<Pizza> findPizzaStartingWith(String beginning) {
        return pizzaRepository.findByNameStartingWith(beginning);
    }

}
