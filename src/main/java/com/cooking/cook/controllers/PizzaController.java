package com.cooking.cook.controllers;

import com.cooking.cook.model.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PizzaController {


    private PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizza")
    public ModelAndView showPizzaForm() {
        return new ModelAndView("pizzaHome", "pizza", new Pizza());
    }

    @PostMapping("/pizza")
    public String submit(@Valid @ModelAttribute(value = "pizza") Pizza newPizza, ModelMap model) {
        model.addAttribute("name", newPizza.getName());
        model.addAttribute("price", newPizza.getPrice());
        model.addAttribute("diameter", newPizza.getDiameter());
        pizzaService.createPizza(newPizza);
        return "pizzaView";
    }
    
}
