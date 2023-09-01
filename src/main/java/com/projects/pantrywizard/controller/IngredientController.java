package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.entity.Ingredient;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    private List<Ingredient> localIngredientList;

    // define @PostConstruct to load the sample ingredient data at runtime
    @PostConstruct
    public void loadSampleData() throws IOException {

        //ingredientRepository.deleteAll();


        // Initialize list as empty
        localIngredientList = new ArrayList<>();


        try (Scanner scanner = new Scanner(Paths.get("C:/Java/pantrywizard/src/main/resources/csv/samples.csv"))){

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");

                int id = Integer.valueOf(parts[0]);
                String name = parts[1];
                int calories = Integer.valueOf(parts[2]);
                double price = Double.parseDouble(parts[3]);
                String imageURL = parts[4];
                String category = parts[5];

                localIngredientList.add(new Ingredient(id, name, calories, price, imageURL, category));

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }

        ingredientRepository.saveAll(localIngredientList);

    }

    //@GetMapping("/ingredients")
    //public List<Ingredient> sayHello() {

        // Jackson converts our list of Ingredients to a JSON array
        //return localIngredientList;
    //}

    @GetMapping("/ingredients")
    public String getIngredients(Model model) {

        model.addAttribute("something", null);

        return "index";
    }



    @GetMapping("/ingredients/{ingredientId}")
    public Ingredient getIngredientById(@PathVariable int ingredientId) {

        return localIngredientList.get(ingredientId);
    }





}
