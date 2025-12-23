package com.example.recepie.repository;

import com.example.recepie.model.TypeCooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeCookingRepository extends JpaRepository<TypeCooking, Long> {
    TypeCooking findByName(String name);
    List<TypeCooking> findAllByOrderByNameAsc();
    boolean existsByName(String name);
    
    @Query("SELECT t FROM TypeCooking t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<TypeCooking> searchByName(@Param("query") String query);
}

