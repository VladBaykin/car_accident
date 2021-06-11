package ru.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.accident.model.Accident;
import ru.accident.model.Rule;
import ru.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AccidentController {
    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", service.getAllAccidentType());
        model.addAttribute("rules", service.getAllRules());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        List<Rule> rules = new ArrayList<>();
        String[] rulesFromUI = req.getParameterValues("rIds");
        Arrays.stream(rulesFromUI)
                .forEach(r -> rules.add(Rule.of(
                        Integer.parseInt(r), "")));
        accident.setRules(rules);
        service.saveAccident(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", service.getAllAccidentType());
        model.addAttribute("rules", service.getAllRules());
        Accident current = service.getAccidentById(id);
        model.addAttribute("accident", current);
        return "accident/edit";
    }
}
