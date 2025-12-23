package com.example.recepie.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_cooking")
public class TypeCooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;
    
    @Column(unique = true, nullable = false, length = 20)
   private String name;
    
    @OneToMany(mappedBy = "typeCooking")
    private List<Recipe> recipes;
    
    public TypeCooking() {}
    public TypeCooking(String name) { this.name = name; }
    
    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public List<Recipe> getRecipes() { return recipes; }
    public void setRecipes(List<Recipe> recipes) { this.recipes = recipes; }
    
    @Override public String toString() { return name; }
}

