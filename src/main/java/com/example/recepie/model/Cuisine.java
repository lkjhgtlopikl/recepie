package com.example.recepie.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cuisine")
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuisineId;
    
    @Column(unique = true, nullable = false, length = 20)
    private String name;
    
    @OneToMany(mappedBy = "cuisine")
    private List<Recipe> recipes;
    
    public Cuisine() {}
    public Cuisine(String name) { this.name = name; }
    
    public Long getCuisineId() { return cuisineId; }
    public void setCuisineId(Long cuisineId) { this.cuisineId = cuisineId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public List<Recipe> getRecipes() { return recipes; }
    public void setRecipes(List<Recipe> recipes) { this.recipes = recipes; }
    
    @Override public String toString() { return name; }
}
