package com.projects.pantrywizard.service;

import com.projects.pantrywizard.dao.IngredientRepository;
import com.projects.pantrywizard.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {

    public void saveIngredient(Ingredient ingredient);
}
