package com.projects.pantrywizard.dao;

import com.projects.pantrywizard.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {


    List<Ingredient> findByCategory(String fruit);
}
