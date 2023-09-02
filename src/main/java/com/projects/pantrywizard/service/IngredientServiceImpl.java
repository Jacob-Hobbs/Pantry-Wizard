package com.projects.pantrywizard.service;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> getIngredientsByCategory(String category) {

        return ingredientRepository.findByCategory(category);
    }

    @Override
    public Optional<Ingredient> getIngredientById(Integer ingredient_id) {
        return ingredientRepository.findById(ingredient_id);
    }

    @Override
    public void updateIngredient(Ingredient updatedIngredient) {
        ingredientRepository.save(updatedIngredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }


}
