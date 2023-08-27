package com.projects.pantrywizard.controller;

import com.projects.pantrywizard.entity.Ingredient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    private Ingredient ingredient;

    public IngredientController(Ingredient theIngredient) {
        this.ingredient = theIngredient;
    }
}
