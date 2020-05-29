package com.albilad.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class HomeController {

    @GetMapping(value = {"/" , "index" , "home"})
    public String reset( Model model ) {
        return "index";
    }

    @GetMapping("otp")
    public String otp() {
        return "otp";
    }

}
