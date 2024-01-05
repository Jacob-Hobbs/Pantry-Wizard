package com.projects.pantrywizard.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
/**
 * @author Jacob Hobbs
 */
public class Recipe {

    @Id
    @Column(name="recipe_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recipe_Id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="calories")
    private int calories;

    @Column(name="imageURL")
    private String imageURL;

    @Column(name="ingredientList")
    @ElementCollection
    private List<String> ingredientList = new ArrayList<>();

    @Column(name="category")
    private String category;

    public Recipe() {
        // blank, no-argument constructor required by JPA
    }

    public Recipe(int recipe_Id, String name, double price, int calories, String imageURL, List<String> ingredientList, String category) {
        this.recipe_Id = recipe_Id;
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.imageURL = imageURL;
        this.ingredientList = ingredientList;
        this.category = category;
    }

    public int getRecipe_Id() {
        return recipe_Id;
    }

    public void setRecipe_Id(int recipe_Id) {
        this.recipe_Id = recipe_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<String> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
