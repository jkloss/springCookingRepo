package com.cooking.cook.controllers;

import com.cooking.cook.data.Pizza;
import com.cooking.cook.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PizzaController {

    private PizzaService pizzaService;
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

//    @GetMapping("/showMenu")
//    public List<Pizza> showMenu() {
//        return pizzaService.getPizzaList();
//    }

    @RequestMapping(method = RequestMethod.GET, name = "/addPizza")
    public String pizzaForm(ModelAndView model) {
        model.addObject("pizza", new Pizza());
        return "pizzaForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPizza")
    public @ResponseBody String savePizza(Pizza pizza) {
        return "hello" + pizza;
    }
    
}
