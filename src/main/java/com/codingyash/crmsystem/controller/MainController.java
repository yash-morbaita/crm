package com.codingyash.crmsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String returnDashboard() {
        return "redirect:/employees/list";
    }

}
