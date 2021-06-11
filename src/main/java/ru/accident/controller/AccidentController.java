package ru.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.accident.model.Accident;
import ru.accident.repository.AccidentMem;
import ru.accident.service.AccidentService;

@Controller
public class AccidentController {
    private final AccidentService service;
    private final AccidentMem store;

    public AccidentController(AccidentService service, AccidentMem store) {
        this.service = service;
        this.store = store;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", store.findAllAccidentTypes());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        service.saveAccident(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", store.findAllAccidentTypes());
        Accident current = store.getAccidentById(id);
        model.addAttribute("accident", current);
        return "accident/edit";
    }
}
