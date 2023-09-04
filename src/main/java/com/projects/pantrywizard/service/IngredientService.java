package com.projects.pantrywizard.service;

import com.projects.pantrywizard.entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IngredientService {

    public void saveIngredient(Ingredient ingredient);

    List<Ingredient> getIngredientsByCategory(String category);

    Optional<Ingredient> getIngredientById(Integer ingredient_id);

    void updateIngredient(Ingredient updatedIngredient);

    void delete(Ingredient ingredient);

    List<String> getIngredientByName(String name);


    List<String> getAllCategories();

    List<String> getIngredientsByCategoryString(String selectedCategory);

    public String getImageURLByName(String ingredientName);
}
