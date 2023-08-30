package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.entity.User;
import com.projects.pantrywizard.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void loadSampleData() {

    }

    @GetMapping("/registerUser")
    public String register(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "newUser";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user) {
        System.out.println(user);




        userService.registerUser(user);

        return "login";
    }
}
