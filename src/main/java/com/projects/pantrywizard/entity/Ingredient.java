package com.projects.pantrywizard.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name="ingredient_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ingredient_id;

    @Column(name="name")
    private String name;

    @Column(name="calories")
    private int calories;

    @Column(name="price")
    private double price;

    @Column(name="imageURL")
    private String imageURL;

    @Column(name="category")
    private String category;

    public Ingredient() {
        // blank, no-argument constructor required by JPA
    }

    public Ingredient(int ingredient_id, String name, int calories, double price, String imageURL, String category) {
        this.ingredient_id = ingredient_id;
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.imageURL = imageURL;
        this.category = category;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient_id=" + ingredient_id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
