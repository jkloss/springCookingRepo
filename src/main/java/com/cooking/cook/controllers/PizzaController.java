package com.cooking.cook.controllers;

import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PizzaController {

    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
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
}
