package com.albilad.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/locale")
    public String locale() {
        return "locale";
    }
}
