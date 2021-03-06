package com.cooking.cook.service;

import com.cooking.cook.model.Pizza;
import com.cooking.cook.repositories.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
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

    public boolean checkIfPizzaExists(String name) {
        return pizzaRepository.findAll().stream()
                .anyMatch(p -> p.getName().equals(name));
    }

    public List<Pizza> sortPizzaThroughName() {
        return pizzaRepository.findAll().stream()
                .sorted(Comparator.comparing(Pizza::getName))
                .collect(toList());
    }

    public Double getPizzaPriceWithRepository(String name) {
        return pizzaRepository.getPizzaPriceFromRepository(name);
    }

    public Long getIdByGivenName(String name) {
        return pizzaRepository.getIdByName(name);
    }
}
