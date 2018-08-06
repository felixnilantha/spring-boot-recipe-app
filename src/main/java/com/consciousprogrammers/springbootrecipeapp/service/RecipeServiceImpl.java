package com.consciousprogrammers.springbootrecipeapp.service;

import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.converter.RecipeCommandToRecipe;
import com.consciousprogrammers.springbootrecipeapp.converter.RecipeToRecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import com.consciousprogrammers.springbootrecipeapp.repositories.RecipeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {


    @NonNull
    private final RecipeRepository recipeRepository;

    @NonNull
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    @NonNull
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Override
    public List<Recipe> getRecipes() {


        log.debug("Start");

        //recipeRepository.findAll().iterator().forEachRemaining(recipes::add);


        List<Recipe>  recipes = recipeRepository.findAll();


        log.debug("end");

        return recipes;
    }

    @Override
    public Recipe findById(long id) {

        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if(optionalRecipe.isPresent()){
            return optionalRecipe.get();
        }
        return null;
    }

    @Override
    @Transactional
    public RecipeCommand create(RecipeCommand recipeCommand) {

        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe newlyCreatedRecipe = recipeRepository.save(recipe);

        RecipeCommand retuenRecipeCommand = recipeToRecipeCommand.convert(newlyCreatedRecipe);

        return retuenRecipeCommand;
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }
}
