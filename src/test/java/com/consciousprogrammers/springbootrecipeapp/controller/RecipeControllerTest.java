package com.consciousprogrammers.springbootrecipeapp.controller;

import com.consciousprogrammers.springbootrecipeapp.command.CategoryCommand;
import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.command.NotesCommand;
import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import com.consciousprogrammers.springbootrecipeapp.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeControllerTest {


    @Mock
    private RecipeService recipeService;

    private RecipeController recipeController;

    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

    }

    @Test
    public void getRecipeTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.findById(anyLong())).thenReturn(recipe);
        mockMvc.perform(get("/recipe/get/1"))
                .andExpect(status().isOk()).andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));


    }

    @Test
    public void createNewRecipeTest() throws Exception {


        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk()).andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void PostRecipeTest() throws Exception {

        final Long ID = 1L;
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        when(recipeService.create(any())).thenReturn(recipeCommand);
        // mockMvc.perform(post("/recipe/create").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(redirectedUrl("/recipe/get/" + recipeCommand.getId()) );
        mockMvc.perform(post("/recipe/create")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection());

    }

    @Test
    public void PutRecipeTest() throws Exception {

        final Long ID = 1L;
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);

        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);
        mockMvc.perform(get("/recipe/update/1"))
                .andExpect(status().isOk()).andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));

    }
}