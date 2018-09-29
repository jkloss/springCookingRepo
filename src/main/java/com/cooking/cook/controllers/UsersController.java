package com.cooking.cook.controllers;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    @GetMapping("/mainMenu")
    public ModelAndView getMainMenu(SecurityContextHolderAwareRequestWrapper wrapper) {
        
    }
}
