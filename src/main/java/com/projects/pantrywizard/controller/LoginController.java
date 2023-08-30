package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    private List<User> userList;

    @PostConstruct
    public void loadSampleData() {

        // Initialize list as empty
        userList = new ArrayList<>();

        // Add sample ingredients to list
        userList.add(new User("admin1", "password"));
        userList.add(new User("admin2", "password"));
        userList.add(new User("admin3", "password"));

    }


    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("something", null);
        return "login";
    }


}
