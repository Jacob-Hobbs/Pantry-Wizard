package com.projects.pantrywizard.service;

import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {

    void saveRecipe(Recipe recipe);

    List<Recipe> getRecipesByCategory(String category);


    List<Ingredient> getIngredientsInRecipe();

    boolean isIngredientUsedInRecipe(String ingredientName);

    List<Recipe> getRecipesByIngredientName(String name);

    void saveRecipes(List<Recipe> recipesToUpdate);

    Optional<Recipe> getRecipeById(Integer recipeId);
}
