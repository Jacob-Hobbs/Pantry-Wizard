package com.projects.pantrywizard.service;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.entity.Ingredient;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<String> getIngredientByName(String name) {

        return ingredientRepository.findIngredientNamesByNames(name);
    }

    @Override
    public List<String> getAllCategories() {

        List<String> categoryList = new ArrayList<>();
        categoryList.add("Fruit");
        categoryList.add("Vegetable");
        categoryList.add("Dairy");
        categoryList.add("Protein");
        categoryList.add("Grains");
        categoryList.add("Herbs & Spices");
        categoryList.add("Other");

        return categoryList;

    }

    @Override
    public List<String> getIngredientsByCategoryString(String selectedCategory) {
        System.out.println(selectedCategory);


        List<Ingredient> ingredientArrayList = ingredientRepository.findByCategory(selectedCategory);

        List<String> ingredientNameList = new ArrayList<>();

        for (Ingredient ingredient: ingredientArrayList) {
            ingredientNameList.add(ingredient.getName());
        }

        System.out.println(ingredientNameList);


        return ingredientNameList;
    }


}
