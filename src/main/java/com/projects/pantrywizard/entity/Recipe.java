package com.projects.pantrywizard.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name="ingedientList")
    @OneToMany
    private List<Ingredient> ingredientList = new ArrayList<>();

    @Column(name="category")
    private String recipeCategory;

    public Recipe() {
        // blank, no-argument constructor required by JPA
    }

    public Recipe(int recipeId, String recipeName, int recipePrice, int recipeCalories, String imageURL, String recipeCategory) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipePrice = recipePrice;
        this.recipeCalories = recipeCalories;
        this.imageURL = imageURL;
        this.recipeCategory = recipeCategory;
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

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipePrice=" + recipePrice +
                ", recipeCalories=" + recipeCalories +
                ", imageURL='" + imageURL + '\'' +
                ", recipeCategory='" + recipeCategory + '\'' +
                '}';
    }
}
