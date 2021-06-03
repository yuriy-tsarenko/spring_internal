package com.example.lesson3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    private final RepositoryCustom repositoryCustom;

    public DemoController(RepositoryCustom repositoryCustom) {
        this.repositoryCustom = repositoryCustom;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/info")
    public String getInfo() {
        return "info";
    }
}
