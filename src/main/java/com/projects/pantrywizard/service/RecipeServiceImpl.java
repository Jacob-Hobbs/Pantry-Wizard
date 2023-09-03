package com.projects.pantrywizard.service;

import com.projects.pantrywizard.dao.RecipeRepository;
import com.projects.pantrywizard.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    @Transactional
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
