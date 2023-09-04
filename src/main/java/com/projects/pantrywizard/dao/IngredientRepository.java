package com.projects.pantrywizard.dao;

import com.projects.pantrywizard.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {


    List<Ingredient> findByCategory(String fruit);

    Ingredient findByName(String name);

    @Query("SELECT i.name FROM Ingredient i WHERE i.name LIKE %:name%")
    List<String> findIngredientNamesByNames(String name);

    List<Ingredient> findByNameIn(List<String> ingredientNamesList);
}
