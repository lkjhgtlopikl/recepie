package com.example.recepie.util;

import com.example.recepie.model.*;
import com.example.recepie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CuisineRepository cuisineRepository;
    @Autowired
    private TypeCookingRepository typeCookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {
        // Инициализация базовых данных
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category("Завтрак"));
            categoryRepository.save(new Category("Обед"));
            categoryRepository.save(new Category("Ужин"));
            categoryRepository.save(new Category("Десерт"));
        }

        if (cuisineRepository.count() == 0) {
            cuisineRepository.save(new Cuisine("Русская"));
            cuisineRepository.save(new Cuisine("Итальянская"));
            cuisineRepository.save(new Cuisine("Французская"));
            cuisineRepository.save(new Cuisine("Китайская"));
        }

        if (typeCookingRepository.count() == 0) {
            typeCookingRepository.save(new TypeCooking("Жарка"));
            typeCookingRepository.save(new TypeCooking("Варка"));
            typeCookingRepository.save(new TypeCooking("Запекание"));
            typeCookingRepository.save(new TypeCooking("Тушение"));
        }
        if (ingredientRepository.count() == 0) {
            ingredientRepository.save(new Ingredient("Морковь","шт"));
            ingredientRepository.save(new Ingredient("Картошка","г"));
            ingredientRepository.save(new Ingredient("Соль","г"));
            ingredientRepository.save(new Ingredient("Перец","г"));
        }

        if (userRepository.count() == 0) {
            User admin = new User("admin", "admin@example.com", "admin123");
            userRepository.save(admin);
        }
    }
}
