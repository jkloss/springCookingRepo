package com.cooking.cook.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource(name = "authenticationManager")
    private AuthenticationManager authenticationManager;

    @GetMapping("/loginNewCustomer")
    public ModelAndView getLoginView() {
        return new ModelAndView("customLoginForm");
    }

    @GetMapping("/errorLogin")
    public ModelAndView getErrorLoginView() {
        return new ModelAndView("errorLogin");
    }

    @PostMapping("/login")
    public void authNewUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
    }

    @GetMapping("/")
    public ModelAndView welcomePageView() {
        return new ModelAndView("welcomeView");
    }
}
