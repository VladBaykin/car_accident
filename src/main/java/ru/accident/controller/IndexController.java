package ru.accident.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.accident.service.AccidentServiceJpa;

@Controller
public class IndexController {

    private final AccidentServiceJpa service;

    public IndexController(AccidentServiceJpa service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", service.getAllAccidents());
        return "index";
    }
}
