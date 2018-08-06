package com.consciousprogrammers.springbootrecipeapp.service;

import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    public List<Recipe> getRecipes();

    public Recipe findById(long id);

    public RecipeCommand create(RecipeCommand recipeCommand);

    public RecipeCommand findCommandById(Long id);
}
