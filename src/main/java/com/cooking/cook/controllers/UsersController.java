package com.cooking.cook.controllers;

import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    @GetMapping("/mainMenu")
    public ModelAndView getMainMenu(SecurityContextHolderAwareRequestWrapper wrapper) {

        if (wrapper.isUserInRole("ADMIN")) {
            return new ModelAndView("mainMenuAdmin");
        }

        if (wrapper.isUserInRole("WORKER")) {
            return new ModelAndView("mainMenuWorker");
        }

        return new ModelAndView("mainMenuUser");
    }

    @GetMapping("/loginNewCustomer")
    public ModelAndView getLoginView() {
        return new ModelAndView("customLoginForm");
    }
}
