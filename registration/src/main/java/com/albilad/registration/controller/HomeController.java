package com.albilad.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class HomeController {
    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("message" , "welcome");
        return "add-user";
    }

    @GetMapping("/")
    public String reset( Model model ) {
        return "index";
    }
}
