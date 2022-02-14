package com.wolanin.watchos.controller;


import com.wolanin.watchos.data.User;
import com.wolanin.watchos.form.RegistrationForm;
import com.wolanin.watchos.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private  PasswordEncoder passwordEncoder;


    @GetMapping
    private String registerForm() {
        return "register";
    }

    @PostMapping
    @Transactional
    public String processRegistration(RegistrationForm form ) {
        User newUser = new User(form.getUsername(), passwordEncoder.encode(form.getPassword()), form.getEmail());
        userRepo.save(newUser);
        return "redirect:/login";
    }


}
