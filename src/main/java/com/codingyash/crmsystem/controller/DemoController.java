package com.codingyash.crmsystem.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class DemoController {

    @GetMapping("/")
    public String getHomePage() {
        return "index.html";
    }

}
