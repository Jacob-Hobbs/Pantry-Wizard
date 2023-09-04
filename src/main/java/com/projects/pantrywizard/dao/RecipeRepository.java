package com.projects.pantrywizard.dao;

import com.projects.pantrywizard.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByCategory(String category);

    boolean existsByIngredientListContaining(String ingredientName);

    List<Recipe> findByIngredientListContaining(String name);
}
