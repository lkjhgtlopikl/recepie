package com.example.recepie.repository;

import com.example.recepie.model.Ingredient;
import com.example.recepie.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByName(String name);
    List<Menu> findAllByOrderByNameAsc();
    List<Menu> findAll();
    boolean existsByName(String name);
    @Query("SELECT t FROM Menu t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Menu> searchByName(@Param("query") String query);
}
