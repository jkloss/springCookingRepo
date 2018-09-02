package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PizzaController {

    private Map<Long, Pizza> pizzaMap = new HashMap<>();

    private PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @RequestMapping(value = "/pizza", method = RequestMethod.GET)
    public ModelAndView showPizzaForm() {
        return new ModelAndView("pizzaHome", "pizza", new Pizza());
    }

    @RequestMapping(value = "/addPizza", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("pizza") final Pizza pizza,
                         final BindingResult result, final ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("id", pizza.getId());
        model.addAttribute("name", pizza.getName());
        model.addAttribute("price", pizza.getPrice());
        model.addAttribute("diameter", pizza.getDiameter());
        pizzaMap.put(pizza.getId(), pizza);

        return "pizzaView";
    }
    
}
