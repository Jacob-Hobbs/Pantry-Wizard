package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.entity.Ingredient;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pantrywizard")
public class IngredientController {

    private List<Ingredient> localIngredientList;

    // define @PostConstruct to load the student data at runtime
    @PostConstruct
    public void loadSampleData() {

        // Initialize list as empty
        localIngredientList = new ArrayList<>();

        // Add sample ingredients to list
        localIngredientList.add(new Ingredient(1, "Apple", 80, 0.89,
                "https://www.collinsdictionary.com/images/full/apple_158989157.jpg", "Fruit"));
        localIngredientList.add(new Ingredient(2, "Rice", 200, 0.15,
                "https://img.etimg.com/thumb/width-1200,height-900,imgsize-161058,resizemode-75,msid-102051894/nri/latest-updates/us-nris-bringing-home-dozens-of-rice-bags-as-india-bans-exports.jpg",
                "Grains"));
        localIngredientList.add(new Ingredient(3, "Eggplant", 40, 1.20,
                "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcRjbf_1QWD0qZ7VP7X4bycHq-Rn_Xd7HXB5GVhD3jvrpXa5HO9WQh63en2UaITQTnUgFaZ-ArIGKgxQ0Ac",
                "Vegetable"));

    }

    @GetMapping("/ingredients")
    public List<Ingredient> sayHello() {

        // Jackson converts our list of Ingredients to a JSON array
        return localIngredientList;
    }

    @GetMapping("/ingredients/{ingredientId}")
    public Ingredient getIngredientById(@PathVariable int ingredientId) {

        return localIngredientList.get(ingredientId);
    }





}
