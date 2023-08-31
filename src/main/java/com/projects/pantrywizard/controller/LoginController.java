package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.dao.UserRepository;
import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.User;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;



    // loading sample data is NOT working!!
    @RequestMapping("/login")
    public void loadSampleData() {
        User defaultAdmin = new User();
        defaultAdmin.setUsername("admin");
        defaultAdmin.setPassword("admin");

        userRepository.save(defaultAdmin);

    }







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

        String userId = user.getUsername();

        Optional<User> userdata = userRepository.findById(userId);



        if (user.getPassword().equals(userdata.get().getPassword())) {
            return "index";
        }


        System.out.println("Incorrect username or password");
        return "login";
    }


}
