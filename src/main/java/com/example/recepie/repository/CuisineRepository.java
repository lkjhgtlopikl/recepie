package com.example.recepie.repository;

import com.example.recepie.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    Cuisine findByName(String name);
    List<Cuisine> findAllByOrderByNameAsc();
    boolean existsByName(String name);
    
    @Query("SELECT c FROM Cuisine c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Cuisine> searchByName(@Param("query") String query);
}
