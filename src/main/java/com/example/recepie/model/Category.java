package com.example.recepie.model;

        import javax.persistence.*;
        import java.util.HashSet;
        import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, unique = true)
    private String name;

    // ОДНОНАПРАВЛЕННАЯ связь - убираем mappedBy
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Recipe> recipes = new HashSet<>();

    // Конструкторы
    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long id) { this.categoryId = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Recipe> getRecipes() { return recipes; }
    public void setRecipes(Set<Recipe> recipes) { this.recipes = recipes; }

    // Методы для работы со связями
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.setCategory(this);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setCategory(null);
    }
}


