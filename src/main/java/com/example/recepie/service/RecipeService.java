package com.example.recepie.service;

import com.example.recepie.model.Recipe;
import com.example.recepie.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    
    @Autowired
    private RecipeRepository recipeRepository;
    
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }
    
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
    
    public List<Recipe> searchRecipes(String query) {
        return recipeRepository.searchRecipes(query);
    }
}

