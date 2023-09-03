package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.dao.RecipeRepository;
import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.Recipe;
import com.projects.pantrywizard.service.IngredientService;
import com.projects.pantrywizard.service.RecipeService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientRepository ingredientRepository;

    private List<Recipe> localRecipeList;

    @PostConstruct
    public void loadSampleDate() throws IOException {

        localRecipeList = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("C:/Java/pantrywizard/src/main/resources/csv/newDinnerSamples.csv"))){

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");

                int id = Integer.valueOf(parts[0]);
                String name = parts[1];
                int calories = Integer.valueOf(parts[2]);
                double price = Double.parseDouble(parts[3]);
                String imageURL = parts[4];
                String ingredients = parts[5];
                String category = parts[6];

                String[] strings = ingredients.split(";");
                List<String> stringIngredients = Arrays.asList(strings);

                localRecipeList.add(new Recipe(id, name, price, calories, imageURL, stringIngredients, category));

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }
        recipeRepository.saveAll(localRecipeList);
    }

    @GetMapping("/recipes/breakfast")
    public String getRecipes(Model model) {

        model.addAttribute("something", null);

        return "breakfast";
    }

















}
