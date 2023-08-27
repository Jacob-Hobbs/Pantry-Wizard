package com.projects.pantrywizard.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
public class Ingredient {

    @Id
    @Column(name="ingredient_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ingredientId;

    @Column(name="name")
    private String ingredientName;

    @Column(name="calories")
    private int ingredientCalories;

    @Column(name="price")
    private double ingredientPrice;

    @Column(name="imageURL")
    private String imageURL;

    @Column(name="category")
    private String category;

    public Ingredient() {
        // blank, no-argument constructor required by JPA
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int newIngredientId) {
        this.ingredientId = newIngredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String newIngredientName) {
        this.ingredientName = newIngredientName;
    }

    public int getIngredientCalories() {
        return ingredientCalories;
    }

    public void setIngredientCalories(int ingredientCalories) {
        this.ingredientCalories = ingredientCalories;
    }

    public double getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(double newIngredientPrice) {
        this.ingredientPrice = newIngredientPrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String newImageURL) {
        this.imageURL = newImageURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String newCategory) {
        this.category = category;
    }
}
