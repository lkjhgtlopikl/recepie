package com.example.recepie.repository;

import com.example.recepie.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    List<Category> findAllByOrderByNameAsc();
    boolean existsByName(String name);
    @Query("SELECT t FROM Category t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Category> searchByName(@Param("query") String query);
}


