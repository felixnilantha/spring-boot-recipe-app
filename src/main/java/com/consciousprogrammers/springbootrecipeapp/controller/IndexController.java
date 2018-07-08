package com.consciousprogrammers.springbootrecipeapp.controller;

import com.consciousprogrammers.springbootrecipeapp.repositories.CategoryRepository;
import com.consciousprogrammers.springbootrecipeapp.repositories.UnitOfMessureRepository;
import com.consciousprogrammers.springbootrecipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/"})
    public String getIndex(Model model){


        model.addAttribute("recipes", recipeService.getRecipes());


        return "index";
    }

}
