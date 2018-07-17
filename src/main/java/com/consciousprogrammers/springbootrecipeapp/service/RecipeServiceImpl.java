package com.consciousprogrammers.springbootrecipeapp.service;

import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import com.consciousprogrammers.springbootrecipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {


    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {


        log.debug("Start");

        //recipeRepository.findAll().iterator().forEachRemaining(recipes::add);


        List<Recipe>  recipes = recipeRepository.findAll();


        log.debug("end");

        return recipes;
    }
}
