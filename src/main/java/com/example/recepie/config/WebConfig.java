package com.example.recepie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("users/login");
        registry.addViewController("/register").setViewName("users/register");
        registry.addViewController("/recipes").setViewName("recipes/list");
        registry.addViewController("/add").setViewName("recipes/add");
        registry.addViewController("/cuisines").setViewName("/management/cuisines");
        registry.addViewController("/categories").setViewName("/management/categories");
        registry.addViewController("/types").setViewName("/management/types");
    }
}