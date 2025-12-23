package com.example.recepie.service;

import com.example.recepie.model.TypeCooking;
import com.example.recepie.repository.TypeCookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCookingService {
    
    @Autowired
    private TypeCookingRepository typeCookingRepository;
    
    public List<TypeCooking> getAllTypes() {
        return typeCookingRepository.findAllByOrderByNameAsc();
    }
    
    public TypeCooking getTypeById(Long id) {
        return typeCookingRepository.findById(id).orElse(null);
    }
    
    public TypeCooking saveType(TypeCooking type) {
        return typeCookingRepository.save(type);
    }
    
    public void deleteType(Long id) {
        typeCookingRepository.deleteById(id);
    }
    
    public boolean typeExists(String name) {
        return typeCookingRepository.existsByName(name);
    }
}
