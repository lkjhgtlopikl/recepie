package com.example.recepie.controller;

import com.example.recepie.model.Recipe;
import com.example.recepie.model.Difficulty;
import com.example.recepie.repository.IngredientRepository;
import com.example.recepie.service.RecipeService;
import com.example.recepie.service.UserService;
import com.example.recepie.repository.CategoryRepository;
import com.example.recepie.repository.CuisineRepository;
import com.example.recepie.repository.TypeCookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CuisineRepository cuisineRepository;
    @Autowired
    private TypeCookingRepository typeCookingRepository;
    @GetMapping
    public String getAllRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes/list";
    }
    @GetMapping("/{id}")
    public String getRecipe(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "recipes/view";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cuisines", cuisineRepository.findAll());
        model.addAttribute("types", typeCookingRepository.findAll());
        //model.addAttribute("ingredients", IngredientRepository.findAll());
        model.addAttribute("difficulties", Difficulty.values());
        model.addAttribute("users", userService.getAllUsers());
        return "recipes/add";
    }
    @PostMapping("/add")
    public String addRecipe(@ModelAttribute Recipe recipe) {
        System.out.println("Instructions length: " +
                (recipe.getInstructions() != null ?
                        recipe.getInstructions().length() : "null"));

        if (recipe.getInstructions() != null &&
                recipe.getInstructions().length() > 65535) {
            System.out.println("Текст слишком длинный! Максимум 65535 символов");
        }
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cuisines", cuisineRepository.findAll());
        model.addAttribute("types", typeCookingRepository.findAll());
        model.addAttribute("difficulties", Difficulty.values());
        model.addAttribute("users", userService.getAllUsers());
        return "recipes/edit";
    }
    @PostMapping("/edit/{id}")
    public String editRecipe(@PathVariable Long id, @ModelAttribute Recipe recipe) {
        recipe.setId(id);
        recipeService.saveRecipe(recipe);
        return "redirect:/recipes";
    }
    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return "redirect:/recipes";
    }
    @GetMapping("/search")
    public String searchRecipes(@RequestParam String query, Model model) {
        model.addAttribute("recipes", recipeService.searchRecipes(query));
        model.addAttribute("query", query);
        return "recipes/list";
    }
}