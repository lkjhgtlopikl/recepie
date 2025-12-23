package com.example.recepie.dto;
import com.example.recepie.model.Difficulty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RecipeRequest {

    @NotBlank(message = "Название рецепта обязательно")
    private String title;

    private String description;

    @NotBlank(message = "Инструкции обязательны")
    private String instructions;

    @NotNull(message = "Время приготовления обязательно")
    private Integer cookingTime;

    @NotNull(message = "Количество порций обязательно")
    private Integer servings;

    @NotNull(message = "Сложность обязательна")
    private Difficulty difficulty;

    @NotNull(message = "Автор обязателен")
    private Long authorId;

    @NotNull(message = "Кухня обязательна")
    private Long cuisineId;

    @NotNull(message = "Тип приготовления обязателен")
    private Long typeId;

    @NotNull(message = "Категория обязательна")
    private Long categoryId;

    private List<Long> ingredientIds;

    // Конструкторы
    public RecipeRequest() {}

    // Геттеры и сеттеры
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    public Integer getCookingTime() { return cookingTime; }
    public void setCookingTime(Integer cookingTime) { this.cookingTime = cookingTime; }

    public Integer getServings() { return servings; }
    public void setServings(Integer servings) { this.servings = servings; }

    public Difficulty getDifficulty() { return difficulty; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public Long getCuisineId() { return cuisineId; }
    public void setCuisineId(Long cuisineId) { this.cuisineId = cuisineId; }

    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public List<Long> getIngredientIds() { return ingredientIds; }
    public void setIngredientIds(List<Long> ingredientIds) { this.ingredientIds = ingredientIds; }
}

