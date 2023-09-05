package com.projects.pantrywizard.service;

import com.projects.pantrywizard.dao.RecipeRepository;
import com.projects.pantrywizard.entity.Ingredient;
import com.projects.pantrywizard.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService{

    private List<Ingredient> ingredientsInRecipe = new ArrayList<>();

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    @Transactional
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getRecipesByCategory(String category) {

        return recipeRepository.findByCategory(category);
    }

    @Override
    public List<Recipe> getRecipesByIngredientName(String name) {
        return recipeRepository.findByIngredientListContaining(name);
    }

    @Override
    public void saveRecipes(List<Recipe> recipesToUpdate) {
        recipeRepository.saveAll(recipesToUpdate);
    }

    @Override
    public Optional<Recipe> getRecipeById(Integer recipeId) {
        return recipeRepository.findById(recipeId);
    }

    @Override
    public void updateRecipe(Recipe updatedRecipe) {
        recipeRepository.save(updatedRecipe);
    }

    @Override
    public void delete(Recipe newRecipe) {
        recipeRepository.delete(newRecipe);
    }
}
