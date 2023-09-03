package com.projects.pantrywizard.service;

import com.projects.pantrywizard.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {

    void saveRecipe(Recipe recipe);

    List<Recipe> getRecipesByCategory(String category);
}
