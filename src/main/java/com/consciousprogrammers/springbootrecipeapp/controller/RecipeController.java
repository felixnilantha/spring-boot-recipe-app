package com.consciousprogrammers.springbootrecipeapp.controller;

import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import com.consciousprogrammers.springbootrecipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/get/{id}")
    public String getRecipeById(@PathVariable String id, Model model){

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        model.addAttribute("recipe",recipe);
        return "recipe/show";

    }
}
