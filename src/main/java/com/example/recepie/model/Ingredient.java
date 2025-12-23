package com.example.recepie.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
    private String unit;

//    // Связь с рецептами (многие ко многим)
//    @ManyToMany(mappedBy = "ingredients")
//    private Set<Recipe> recipes = new HashSet<>();

    // Конструкторы, геттеры, сеттеры
    public Ingredient() {
    }

    public Ingredient(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

//    public Set<Recipe> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(Set<Recipe> recipes) {
//        this.recipes = recipes;
//    }
}
