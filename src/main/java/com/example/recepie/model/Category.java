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
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Recipe> recipes = new HashSet<>();
    public Category() {}
    public Category(String name) {
        this.name = name;
    }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long id) { this.categoryId = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Recipe> getRecipes() { return recipes; }
    public void setRecipes(Set<Recipe> recipes) { this.recipes = recipes; }
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.setCategory(this);
    }
    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setCategory(null);
    }
}


