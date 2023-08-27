package com.projects.pantrywizard.entity;


public class Ingredient {

    private int ingredientId;
    private String ingredientName;
    private double ingredientPrice;
    private String imageURL;
    private String category;

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
