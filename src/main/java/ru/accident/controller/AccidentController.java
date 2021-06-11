package ru.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.accident.model.Accident;
import ru.accident.repository.AccidentMem;

@Controller
public class AccidentController {
    private final AccidentMem accidents;

    public AccidentController(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        if (accident.getId() != 0) {
            accidents.update(accident);
        } else {
            accidents.create(accident);
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model) {
        Accident current = accidents.getAccidentById(id);
        model.addAttribute("accident", current);
        return "accident/edit";
    }
}
