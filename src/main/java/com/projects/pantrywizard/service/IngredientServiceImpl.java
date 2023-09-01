package com.projects.pantrywizard.service;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
