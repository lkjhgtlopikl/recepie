package com.example.recepie.repository;

import com.example.recepie.model.Ingredient;
import com.example.recepie.model.TypeCooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByName(String name);
    List<Ingredient> findAllByOrderByNameAsc();
    List<Ingredient> findAll();
    boolean existsByName(String name);
    @Query("SELECT t FROM Ingredient t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Ingredient> searchByName(@Param("query") String query);
}
