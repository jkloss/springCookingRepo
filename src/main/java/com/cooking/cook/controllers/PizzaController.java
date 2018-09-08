package com.cooking.cook.controllers;

import com.cooking.cook.model.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PizzaController {


    private PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizza")
    public String showPizzaForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizzaHome";
    }

    @PostMapping("/addPizza")
    public String submit(@ModelAttribute("pizza") Pizza pizza, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        return "pizzaView";
    }
    
}
