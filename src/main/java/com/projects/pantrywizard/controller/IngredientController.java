package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.service.IngredientService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientService ingredientService;

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

    @PostMapping("/addIngredient")
    public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {





        ingredientService.saveIngredient(ingredient);

        // use "Post/Redirect/Get" (PRG) pattern to prevent data duplication.
        return "redirect:/ingredients/fruit";
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

    @GetMapping("/addIngredient")
    public String addIngredient(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);



        return "addIngredient";
    }

    @GetMapping("/ingredients/fruit")
    public String getFruitIngredients(Model model) {

        model.addAttribute("another", null);

        List<Ingredient> fruits = ingredientService.getIngredientsByCategory("Fruit");


        for (Ingredient fruit: fruits) {
            if (!(fruit.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                fruit.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }


        model.addAttribute("fruits", fruits);
        return "fruit";
    }




    @GetMapping("/ingredients/vegetable")
    public String getVegetableIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> vegetables = ingredientService.getIngredientsByCategory("Vegetable");
        model.addAttribute("vegetables", vegetables);

        return "vegetable";
    }

    @GetMapping("/ingredients/dairy")
    public String getDairyIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> dairys = ingredientService.getIngredientsByCategory("Dairy");
        model.addAttribute("dairys", dairys);

        return "dairy";
    }

    @GetMapping("/ingredients/protein")
    public String getProteinIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> proteins = ingredientService.getIngredientsByCategory("Protein");
        model.addAttribute("proteins", proteins);

        return "protein";
    }

    @GetMapping("/ingredients/grains")
    public String getGrainsIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> grains = ingredientService.getIngredientsByCategory("Grains");
        model.addAttribute("grains", grains);

        return "grains";
    }

    @GetMapping("/ingredients/herbs&spices")
    public String getHerbsAndSpicesIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> herbsAndSpices = ingredientService.getIngredientsByCategory("Herbs & Spices");
        model.addAttribute("herbsAndSpices", herbsAndSpices);

        return "herbsAndSpices";
    }

    @GetMapping("/ingredients/other")
    public String getOtherIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> others = ingredientService.getIngredientsByCategory("Other");
        model.addAttribute("others", others);

        return "other";
    }







}
