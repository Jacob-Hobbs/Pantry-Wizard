package com.projects.pantrywizard.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
public class Recipe {

    @Id
    @Column(name="recipe_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recipeId;

    @Column(name="name")
    private String recipeName;

    @Column(name="price")
    private int recipePrice;

    @Column(name="calories")
    private int recipeCalories;

    @Column(name="imageURL")
    private String imageURL;

    @Column(name="category")
    private String recipeCategory;

    public Recipe() {
        // blank, no-argument constructor required by JPA
    }


    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getRecipePrice() {
        return recipePrice;
    }

    public void setRecipePrice(int recipePrice) {
        this.recipePrice = recipePrice;
    }

    public int getRecipeCalories() {
        return recipeCalories;
    }

    public void setRecipeCalories(int recipeCalories) {
        this.recipeCalories = recipeCalories;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }
}
