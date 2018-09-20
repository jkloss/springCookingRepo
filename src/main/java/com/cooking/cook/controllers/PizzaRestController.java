package com.cooking.cook.controllers;

import com.cooking.cook.model.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pizza/dimensions")
    public List<Pizza> getPizzaGreaterThanGivenNumber(@RequestParam(value = "number") Integer number) {
        return pizzaService.getPizzaWhichIsGreaterThanGivenNumber(number);
    }

    @RequestMapping("pizza/delete")
    public void deletePizza(@RequestParam(value = "id") Long id) {
        pizzaService.deleteRecord(id);
    }


    @GetMapping("/pizza/avg")
    public double getPizzaAvg() {
        return pizzaService.getPizzaPriceAvg();
    }

    @GetMapping("/pizza/sum")
    public double getPizzaPriceSum() {
        return pizzaService.getPizzaPriceSum();
    }

    @GetMapping("/pizza/startsWith")
    public List<Pizza> findPizzaStartingWith(@RequestParam(value = "beginning") String beginning) {
        return pizzaService.findPizzaStartingWith(beginning);
    }
}
