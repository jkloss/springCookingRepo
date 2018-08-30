package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PizzaController {

    private PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/showMenu")
    public List<Pizza> showMenu() {
        return pizzaService.getPizzaList();
    }


    @RequestMapping(value = "/addPizza", method = RequestMethod.GET)
    public ModelAndView getForm() {
        return new ModelAndView("addPizzaForm.html");
    }

    @RequestMapping(value = "submitPizzaForm", method = RequestMethod.POST)
    public ModelAndView submitPizzaForm(@RequestParam("pizzaName") String name,
                                        @RequestParam("pizzaPrice") double price,
                                        @RequestParam("pizzaDiameter") int diameter) {
     ModelAndView model = new ModelAndView("submitPizzaForm.html");

     model.addObject("msg", "Details: Name: " + name + "Price: " + price + "Diameter: "
             + diameter);

     return model;
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
