package ru.petr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    private static final String AUTHORIZATION_JSP = "authorization";

    @GetMapping("/")
    public String welcomePage() {
        return AUTHORIZATION_JSP;
    }
}
