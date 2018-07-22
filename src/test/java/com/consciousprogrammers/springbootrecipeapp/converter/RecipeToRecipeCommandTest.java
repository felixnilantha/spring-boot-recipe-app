package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.CategoryCommand;
import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.command.NotesCommand;
import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeToRecipeCommandTest {

    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setUp() throws Exception {
        recipeToRecipeCommand = new RecipeToRecipeCommand(new CategoryToCategoryCommand(),new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()), new NoteToNoteCommand() );
    }

    @Test
    public void convert() {

        final Long ID = 1L;
        final Integer PREP_TIME=1;
        final Integer COOK_TIME=1;
        final String DESCRIPTION ="description";
        final String  DIRECTIONS ="directions";
        final String SOURCE = "source";
        final String URL ="url";
        final Integer SERVINGS =5;

        Recipe recipe = new Recipe();
        recipe.setId(ID);
        recipe.setPrepTime(PREP_TIME);
        recipe.setCookTime(COOK_TIME);
        recipe.setDescription(DESCRIPTION);


        recipe.setDificulty(Dificulty.EASY);
        recipe.setDirections(DIRECTIONS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);
        recipe.setServings(SERVINGS);

        // Add Ingredients
        Ingredient ingredient1 = new Ingredient();
        Ingredient ingredient2 = new Ingredient();

        final Long INGREDIENT1_ID = 1L;
        final Long INGREDIENT2_ID = 2L;
        ingredient1.setId(INGREDIENT1_ID);
        ingredient2.setId(INGREDIENT2_ID);

        Set<Ingredient> ingredientSet = new HashSet(0);
        ingredientSet.add(ingredient1);
        ingredientSet.add(ingredient2);

        recipe.setIngredients(ingredientSet);

        // Add Notes
        Notes notes = new Notes();

        final Long Notes_ID = 1L;
        notes.setId(Notes_ID);

        recipe.setNotes(notes);

        //Add Categories

        Category category1 = new Category();
        Category category2 = new Category();

        final Long Category_ID1=1L;
        final Long Category_ID2=2L;
        category1.setId(Category_ID1);
        category2.setId(Category_ID2);

        Set<Category> categories = new HashSet(0);
        categories.add(category1);
        categories.add(category2);

        recipe.setCategories(categories);



        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);

        assertNotNull(recipe);
        assertEquals(ID,recipeCommand.getId());
        assertEquals(PREP_TIME,recipeCommand.getPrepTime());
        assertEquals(COOK_TIME,recipeCommand.getCookTime());
        assertEquals(DESCRIPTION,recipeCommand.getDescription());
        assertEquals(DIRECTIONS,recipeCommand.getDirections());
        assertEquals(SOURCE,recipeCommand.getSource());
        assertEquals(URL,recipeCommand.getUrl());
        assertEquals(SERVINGS,recipeCommand.getServings());

        assertEquals(2,recipeCommand.getCategories().size());
        assertEquals(2,recipeCommand.getIngredients().size());

    }
}