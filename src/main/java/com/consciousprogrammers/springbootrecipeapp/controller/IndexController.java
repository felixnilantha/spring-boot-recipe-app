package com.consciousprogrammers.springbootrecipeapp.controller;

import com.consciousprogrammers.springbootrecipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/"})
    public String getIndex(Model model){


        model.addAttribute("recipes", recipeService.getRecipes());

        log.debug("ready to load -> index page");


        return "index";
    }

}
