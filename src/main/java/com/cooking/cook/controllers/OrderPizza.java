package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.service.OrderPizzaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderPizza {

    private OrderPizzaService orderPizzaService;
    public OrderPizza(OrderPizzaService orderPizzaService) {
        this.orderPizzaService = orderPizzaService;
    }

    @GetMapping("/showMenu")
    public List<Pizza> showMenu() {
        return orderPizzaService.getPizzaList();
    }

    @PostMapping("/addPizza")
    public void createPizza(@RequestBody @Valid Pizza pizza) {
        orderPizzaService.createPizza(pizza);
    }
//    @GetMapping("/showOrder/{name}")
//    public List<Pizza> showOrder(@PathVariable String name) {
//        return restaurant.getMenu().stream()
//                .filter(pizza -> pizza.getName().equals(name))
//                .collect(toList());
//    }
//
//    @GetMapping("/sortNames")
//    public List<String> sortPizzaNames() {
//        return restaurant.getMenu().stream()
//                .map(Pizza::getName)
//                .sorted()
//                .collect(toList());
//    }
//
//    @GetMapping("/choosePizzaStartsWith/{letter}")
//    public List<Pizza> choosePizzaStartsWith(@PathVariable String letter) {
//        return restaurant.getMenu().stream()
//                .filter(pizza -> pizza.getName().startsWith(letter))
//                .collect(toList());
//    }
//
//    @GetMapping("/choosePizzaUnder40Diam")
//    public List<Pizza> choosePizzaUnder40Diam() {
//        return restaurant.getMenu().stream()
//                .filter(pizza -> pizza.getDiameter() < 40)
//                .collect(toList());
//    }
//
//    @GetMapping("/chooseTheCheapestPizza")
//    public Pizza chooseTheCheapestPizza() {
//        return restaurant.getMenu().stream()
//                .min(Comparator.comparingDouble(Pizza::getPrice))
//                .orElse(null);
//    }
}
