/**
 * @author Jacob Hobbs
 */
package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.Recipe;
import com.projects.pantrywizard.service.IngredientService;
import com.projects.pantrywizard.service.RecipeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.util.*;

/**
 * The IngredientController class acts as the mediator between ingredient views and models,
 * facilitating the call of HTTP requests.
 * */
@Controller
@RequestMapping
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;

    private List<Ingredient> localIngredientList;

    /**
     * loadSampleData is a post construct method that feeds hard-coded sample data into the model
     * at runtime.
     * */
    @PostConstruct
    public void loadSampleData() {

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

    /**
     * addIngredient is a posting method that communicates to the model that a new
     * ingredient entity must be created and saved in the database.
     *
     * New ingredient attributes are bound to the parameterized Ingredient object which are then
     * saved as a new ingredient entry. The user is then redirected to the ingredient page
     * matching the newly stored ingredient's category.
     * */
    @PostMapping("/addIngredient")
    public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {

        ingredientService.saveIngredient(ingredient);

        String category = ingredient.getCategory().toLowerCase();

        if (category.equals("herbs & spices")) {
            category = "herbs&spices";
        }

        return "redirect:/ingredients/" + category;
    }

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

    @GetMapping("/updateIngredient")
    public String updateIngredientPage(@RequestParam("ingredient_id") Integer ingredient_id, Model model) {


        Optional<Ingredient> ingredient = ingredientService.getIngredientById(ingredient_id);

        if (ingredient.isPresent()) {
            Ingredient ingredientEntity = ingredient.get();
            model.addAttribute("ingredient", ingredientEntity);
        }

        return "updateIngredient";
    }

    @PostMapping("/updateIngredient")
    public String updateIngredient(@ModelAttribute("ingredient") Ingredient updatedIngredient) {
        ingredientService.updateIngredient(updatedIngredient);

        String category = updatedIngredient.getCategory().toLowerCase();

        if (category.equals("herbs & spices")) {
            category = "herbs&spices";
        }

        return "redirect:/ingredients/" + category;
    }

    @PostMapping("/deleteIngredient")
    public String deleteIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {

        Optional<Ingredient> existingIngredient = ingredientService.getIngredientById(ingredient.getIngredient_id());


        if (existingIngredient.isPresent()) {

            Ingredient newIngredient = existingIngredient.get();

            System.out.println("Searching for recipes with ingredient name: " + newIngredient.getName());
            List<Recipe> recipesToUpdate = recipeService.getRecipesByIngredientName(newIngredient.getName());
            System.out.println("Recipes to update: " + recipesToUpdate.toString());

            // Update the ingredientList of each recipe
            for (Recipe recipe : recipesToUpdate) {
                List<String> updatedIngredientList = new ArrayList<>(recipe.getIngredientList());
                updatedIngredientList.remove(newIngredient.getName());
                recipe.setIngredientList(updatedIngredientList);
            }

            // Save the updated recipes
            recipeService.saveRecipes(recipesToUpdate);

            ingredientService.delete(existingIngredient.get());
            return "redirect:/ingredients/fruit";
        } else {
            System.out.println("Ingredient not found!!");
        }
        return "redirect:/ingredients/fruit";
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

        for (Ingredient vegetable: vegetables) {
            if (!(vegetable.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                vegetable.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("vegetables", vegetables);
        return "vegetable";
    }

    @GetMapping("/ingredients/dairy")
    public String getDairyIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> dairys = ingredientService.getIngredientsByCategory("Dairy");

        for (Ingredient dairy: dairys) {
            if (!(dairy.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                dairy.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("dairys", dairys);
        return "dairy";
    }

    @GetMapping("/ingredients/protein")
    public String getProteinIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> proteins = ingredientService.getIngredientsByCategory("Protein");

        for (Ingredient protein: proteins) {
            if (!(protein.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                protein.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("proteins", proteins);
        return "protein";
    }

    @GetMapping("/ingredients/grains")
    public String getGrainsIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> grains = ingredientService.getIngredientsByCategory("Grains");

        for (Ingredient grain: grains) {
            if (!(grain.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                grain.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("grains", grains);
        return "grains";
    }

    @GetMapping("/ingredients/herbs&spices")
    public String getHerbsAndSpicesIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> herbsAndSpices = ingredientService.getIngredientsByCategory("Herbs & Spices");

        for (Ingredient herbOrSpice: herbsAndSpices) {
            if (!(herbOrSpice.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                herbOrSpice.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("herbsAndSpices", herbsAndSpices);
        return "herbsAndSpices";
    }

    @GetMapping("/ingredients/other")
    public String getOtherIngredients(Model model) {
        model.addAttribute("another", null);

        List<Ingredient> others = ingredientService.getIngredientsByCategory("Other");

        for (Ingredient other: others) {
            if (!(other.getImageURL().contains("https://"))) {
                System.out.println("BAD IMAGE!!");
                other.setImageURL("https://www.pngitem.com/pimgs/m/79-797178_fork-and-knife-crossed-like-the-letter-x.png");
            }
        }

        model.addAttribute("others", others);
        return "other";
    }

    @GetMapping("/getIngredientsByCategory")
    @ResponseBody
    public List<String> getIngredientsByCategory(@RequestParam String category) {
        return ingredientService.getIngredientsByCategoryString(category);
    }










}
