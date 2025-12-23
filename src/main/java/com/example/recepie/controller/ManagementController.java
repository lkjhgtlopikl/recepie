package com.example.recepie.controller;

import com.example.recepie.model.Category;
import com.example.recepie.model.Cuisine;
import com.example.recepie.model.TypeCooking;
import com.example.recepie.repository.CategoryRepository;
import com.example.recepie.repository.CuisineRepository;
import com.example.recepie.repository.TypeCookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/management")
public class ManagementController {
    
    @Autowired private CuisineRepository cuisineRepository;
    @Autowired private TypeCookingRepository typeCookingRepository;
    @Autowired private CategoryRepository categoryRepository;

    // Кухни
    @GetMapping("/cuisines")
    public String listCuisines(Model model) {
        model.addAttribute("cuisines", cuisineRepository.findAllByOrderByNameAsc());
        model.addAttribute("newCuisine", new Cuisine());
        return "management/cuisines";
    }

    @PostMapping("/cuisines/add")
    public String addCuisine(@ModelAttribute Cuisine cuisine) {
        if (!cuisineRepository.existsByName(cuisine.getName())) {
            cuisineRepository.save(cuisine);
        }
        return "redirect:/management/cuisines";
    }

    @GetMapping("/cuisines/delete/{id}")
    public String deleteCuisine(@PathVariable Long id) {
        cuisineRepository.deleteById(id);
        return "redirect:/management/cuisines";
    }

    // Типы приготовления
    @GetMapping("/types")
    public String listTypes(Model model) {
        model.addAttribute("types", typeCookingRepository.findAllByOrderByNameAsc());
        model.addAttribute("newType", new TypeCooking());
        return "management/types";
    }

    @PostMapping("/types/add")
    public String addType(@ModelAttribute TypeCooking type) {
        if (!typeCookingRepository.existsByName(type.getName())) {
            typeCookingRepository.save(type);
        }
        return "redirect:/management/types";
    }

    @GetMapping("/types/delete/{id}")
    public String deleteType(@PathVariable Long id) {
        typeCookingRepository.deleteById(id);
        return "redirect:/management/types";
    }

    // Категории
    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAllByOrderByNameAsc());
        model.addAttribute("newCategory", new Category());
        return "management/categories";
    }

    @PostMapping("/categories/add")
    public String addCategory(@ModelAttribute Category category) {
        if (!categoryRepository.existsByName(category.getName())) {
            categoryRepository.save(category);
        }
        return "redirect:/management/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return "redirect:/management/categories";
    }
}

