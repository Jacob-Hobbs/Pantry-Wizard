package com.projects.pantrywizard.service;

import com.projects.pantrywizard.entity.Recipe;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService {

    void saveRecipe(Recipe recipe);
}
