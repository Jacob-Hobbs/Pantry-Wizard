/**
 * @author Jacob Hobbs
 */
package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.dao.RecipeRepository;
import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.Recipe;
import com.projects.pantrywizard.service.IngredientService;
import com.projects.pantrywizard.service.RecipeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

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

    private Recipe oldRecipe;

    private List<Recipe> localRecipeList;

    @PostConstruct
    public void loadSampleDate() {

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
    public String getBreakfast(Model model) {

        model.addAttribute("something", null);

        List<Recipe> breakfasts = recipeService.getRecipesByCategory("Breakfast");

        for (Recipe breakfast: breakfasts) {
            if (!(breakfast.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                breakfast.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("breakfasts", breakfasts);

        return "breakfast";
    }

    @GetMapping("/recipes/lunch")
    public String getLunch(Model model) {

        model.addAttribute("something", null);

        List<Recipe> lunchs = recipeService.getRecipesByCategory("Lunch");

        for (Recipe lunch: lunchs) {
            if (!(lunch.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                lunch.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("lunchs", lunchs);

        return "lunch";
    }

    @GetMapping("/recipes/dinner")
    public String getDinner(Model model) {

        model.addAttribute("something", null);

        List<Recipe> dinners = recipeService.getRecipesByCategory("Dinner");

        for (Recipe dinner: dinners) {
            if (!(dinner.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                dinner.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("dinners", dinners);

        return "dinner";
    }

    @GetMapping("/recipes/appetizers")
    public String getAppetizers(Model model) {

        model.addAttribute("something", null);

        List<Recipe> appetizers = recipeService.getRecipesByCategory("Appetizers");

        for (Recipe appetizer: appetizers) {
            if (!(appetizer.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                appetizer.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("appetizers", appetizers);

        return "appetizers";
    }

    @GetMapping("/recipes/dessert")
    public String getDessert(Model model) {

        model.addAttribute("something", null);

        List<Recipe> desserts = recipeService.getRecipesByCategory("Dessert");

        for (Recipe dessert: desserts) {
            if (!(dessert.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                dessert.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("desserts", desserts);

        return "dessert";
    }

    @GetMapping("/addRecipe")
    public String showAddRecipePage(Model model) {

        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);


        List<String> categories = ingredientService.getAllCategories();
        model.addAttribute("categories", categories);

        return "addRecipe";
    }

    @PostMapping("/addIngredientToRecipe")
    public ResponseEntity<String> addIngredientToRecipe(@RequestParam String category, @RequestParam String ingredient, Model model) {

        Ingredient newIngredient = ingredientRepository.findByName(ingredient);

        String newIngredientRow = "<tr>" +
                "<td>" + newIngredient.getName() + "</td>" +
                "<td>" + newIngredient.getCalories() + "</td>" +
                "<td>" + newIngredient.getPrice() + "</td>" +
                "<td>" + newIngredient.getCategory() + "</td>" +
                "<td><button class='btn btn-primary removeIngredient'>Remove</button></td>" +
                "</tr>";

        // Return the HTML as a response entity
        return ResponseEntity.ok(newIngredientRow);

    }

    @PostMapping("/addRecipe")
    public String addRecipe(@ModelAttribute("recipe") Recipe recipe, Model model, @RequestParam List<String> ingredientNames) {

        System.out.println("@@@ Ingredient Names List: " + ingredientNames);

        recipe.setIngredientList(ingredientNames);


        String category = recipe.getCategory();

        System.out.println("Raw category: " + category);


        if (category.contains("Breakfast") || category.contains("Lunch") || category.contains("Dinner") ||
        category.contains("Appetizers") || category.contains("Dessert")) {

            String[] parts = category.split(",");

            String fixedCategory = parts[1];

            System.out.println("Fixed Category: " + fixedCategory);


            recipe.setCategory(fixedCategory);

            recipeService.saveRecipe(recipe);


            String lowercaseCategory = recipe.getCategory().toLowerCase();

            System.out.println("Lowercase Category: " + lowercaseCategory);


            return "redirect:/recipes/" + lowercaseCategory;
        }
        return "redirect:/recipes";

    }

    @GetMapping("/updateRecipe")
    public String updateRecipePage(@RequestParam("recipe_id") Integer recipe_id, Model model) {


        Optional<Recipe> recipe = recipeService.getRecipeById(recipe_id);



        if (recipe.isPresent()) {
            Recipe recipeEntity = recipe.get();

            oldRecipe = recipeEntity;
            model.addAttribute("recipe", recipeEntity);

            List<String> ingredientNamesList = recipeEntity.getIngredientList();

            List<Ingredient> ingredients = ingredientService.getIngredientsByName(ingredientNamesList);

            System.out.println(ingredients.toString());

            model.addAttribute("ingredients", ingredients);

        }

        return "updateRecipe";
    }

    @PostMapping("/updateRecipe")
    public String updateRecipe(@ModelAttribute("updatedRecipe") Recipe updatedRecipe) {

        String category = updatedRecipe.getCategory();

        System.out.println("Id: " + updatedRecipe.getRecipe_Id());
        System.out.println("Name: " + updatedRecipe.getName());
        System.out.println("Calories: " + updatedRecipe.getCalories());
        System.out.println("Price: " + updatedRecipe.getPrice());
        System.out.println("Ingredient List: " + updatedRecipe.getIngredientList().toString());
        System.out.println("Category: " + updatedRecipe.getCategory());

        oldRecipe.setName(updatedRecipe.getName());
        oldRecipe.setCalories(updatedRecipe.getCalories());
        oldRecipe.setPrice(updatedRecipe.getPrice());
        oldRecipe.setCategory(updatedRecipe.getCategory());
        oldRecipe.setImageURL(updatedRecipe.getImageURL());

        // update ingredientList
        oldRecipe.setIngredientList(updatedRecipe.getIngredientList());


            recipeService.updateRecipe(oldRecipe);

            category = updatedRecipe.getCategory().toLowerCase();

        System.out.println("Category Lower Case: " + category);

            return "redirect:/recipes/" + category;



    }

    @PostMapping("/deleteRecipe")
    public String deleteRecipe(@ModelAttribute("recipe") Recipe recipe) {

        Optional<Recipe> existingRecipe = recipeService.getRecipeById(recipe.getRecipe_Id());

        if (existingRecipe.isPresent()) {

            Recipe newRecipe = existingRecipe.get();

            recipeService.delete(newRecipe);
            return "redirect:/recipes/breakfast";
        } else {
            System.out.println("Recipe not found!!");
        }
        return "redirect:/recipes/breakfast";
    }























}
