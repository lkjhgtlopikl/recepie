package com.example.recepie.repository;

import com.example.recepie.model.Recipe;
import com.example.recepie.model.User;
import com.example.recepie.model.Cuisine;
import com.example.recepie.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitleContainingIgnoreCase(String title);
    List<Recipe> findByAuthor(User author);
    List<Recipe> findByCuisine(Cuisine cuisine);
    List<Recipe> findByCategory(Category category);
    
    @Query("SELECT r FROM Recipe r WHERE LOWER(r.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(r.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Recipe> searchRecipes(@Param("query") String query);
}


