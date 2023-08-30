package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {

        User user = new User();

        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user) {

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        return "index";
    }


}
