package ru.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.accident.model.User;
import ru.accident.repository.springdatajpa.AuthorityRepository;
import ru.accident.repository.springdatajpa.UserRepository;

@Controller
public class RegController {

    private final PasswordEncoder encoder;
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    @Autowired
    public RegController(PasswordEncoder encoder, AuthorityRepository authorityRepository, UserRepository userRepository) {
        this.encoder = encoder;
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "accident/reg";
    }
}
