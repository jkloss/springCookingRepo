package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PizzaController {

    private PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pizza")
    public ModelAndView showPizzaForm() {
        return new ModelAndView("pizzaHome", "pizza", new Pizza());
    }

    @RequestMapping(value = "/addPizza", method = RequestMethod.POST)
    public String submitPizza(@Valid @ModelAttribute("pizza") Pizza pizza,
                              BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("id", pizza.getId());
        model.addAttribute("name", pizza.getName());
        model.addAttribute("price", pizza.getPrice());
        model.addAttribute("diameter", pizza.getDiameter());

        return "pizzaView";
    }
    
}
