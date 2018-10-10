package com.cooking.cook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/loginNewCustomer")
    public ModelAndView getLoginView() {
        return new ModelAndView("customLoginForm");
    }

    @GetMapping("/errorLogin")
    public ModelAndView getErrorLoginView() {
        return new ModelAndView("errorLogin");
    }
}
