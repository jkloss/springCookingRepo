package com.cooking.cook.controllers;

import com.cooking.cook.model.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/addPizza")
    public String submit(@Valid @RequestBody final Pizza pizza,
                         final BindingResult result, final ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("id", pizza.getId());
        model.addAttribute("name", pizza.getName());
        model.addAttribute("price", pizza.getPrice());
        model.addAttribute("diameter", pizza.getDiameter());
        pizzaService.createPizza(pizza);
        return "pizzaView";
    }
    
}
