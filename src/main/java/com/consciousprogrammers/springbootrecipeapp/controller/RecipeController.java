package com.consciousprogrammers.springbootrecipeapp.controller;

import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import com.consciousprogrammers.springbootrecipeapp.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/get/{id}")
    public String getRecipeById(@PathVariable String id, Model model) {

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        model.addAttribute("recipe", recipe);
        return "recipe/show";

    }

    @GetMapping("/new")
    public String addNewRecipe(Model model) {

        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";

    }

    @GetMapping("/update/{id}")
    public String updateRecipe(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";

    }

    @PostMapping("/create")
    public String createOrUpdate(@ModelAttribute RecipeCommand recipeCommand) {

        RecipeCommand createRecipeCommand = recipeService.create(recipeCommand);

        return "redirect:/recipe/get/" + createRecipeCommand.getId();

        //return new ResponseEntity<RecipeCommand>(createRecipeCommand, HttpStatus.CREATED);
    }




}
