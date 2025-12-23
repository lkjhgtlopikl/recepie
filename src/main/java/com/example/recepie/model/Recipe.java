package com.example.recepie.model;

import com.example.recepie.model.Difficulty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String instructions;
    private Integer cookingTime;
    private Integer servings;

    // Связь с категорией
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    // Связь с ингредиентами
//    @ManyToMany
//    @JoinTable(
//            name = "recipe_ingredients",
//            joinColumns = @JoinColumn(name = "recipe_id"),
//            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
//    )
//    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    // Другие связи
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeCooking typeCooking;

    // Конструкторы
    public Recipe() {
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getInstructions() {
        return instructions; // Убедитесь, что тип возвращаемого значения совпадает с типом поля
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions; // Убедитесь, что тип параметра совпадает с типом поля
    }

    // ВАЖНО: Правильное название поля - user
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

//    public Set<Ingredient> getIngredients() { return ingredients; }
//    public void setIngredients(Set<Ingredient> ingredients) { this.ingredients = ingredients; }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public TypeCooking getTypeCooking() {
        return typeCooking;
    }

    public void setTypeCooking(TypeCooking typeCooking) {
        this.typeCooking = typeCooking;
    }

    // Методы для работы с ингредиентами
//    public void addIngredient(Ingredient ingredient) {
//        ingredients.add(ingredient);
//        ingredient.getRecipes().add(this);
//    }
//
//    public void removeIngredient(Ingredient ingredient) {
//        ingredients.remove(ingredient);
//        ingredient.getRecipes().remove(this);
//    }
}


