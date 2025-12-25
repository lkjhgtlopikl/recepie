package com.example.recepie.service;

import com.example.recepie.model.Cuisine;
import com.example.recepie.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuisineService {
    @Autowired
    private CuisineRepository cuisineRepository;
    public List<Cuisine> getAllCuisines() {
        return cuisineRepository.findAllByOrderByNameAsc();
    }
    public Cuisine getCuisineById(Long id) {
        return cuisineRepository.findById(id).orElse(null);
    }
    public Cuisine saveCuisine(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }
    public void deleteCuisine(Long id) {
        cuisineRepository.deleteById(id);
    }
    public boolean cuisineExists(String name) {
        return cuisineRepository.existsByName(name);
    }
}
