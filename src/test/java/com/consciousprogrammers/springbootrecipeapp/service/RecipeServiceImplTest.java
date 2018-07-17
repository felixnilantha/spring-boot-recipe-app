package com.consciousprogrammers.springbootrecipeapp.service;

import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import com.consciousprogrammers.springbootrecipeapp.repositories.RecipeRepository;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {




    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);

    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();

        List<Recipe> recipeSet = new ArrayList<>();
        recipeSet.add(recipe);


       when(recipeRepository.findAll()).thenReturn(recipeSet);

       // doReturn(recipeSet).when(recipeService).getRecipes();

        List<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();

    }
}