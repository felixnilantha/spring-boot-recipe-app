package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.CategoryCommand;
import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.command.NotesCommand;
import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Dificulty;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {


    private  RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        recipeCommandToRecipe = new RecipeCommandToRecipe(new CategoryCommandToCategory(),new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()), new NoteCommandToNote() );
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

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(ID);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setDescription(DESCRIPTION);


        recipeCommand.setDificulty(Dificulty.EASY);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);
        recipeCommand.setServings(SERVINGS);

        // Add Ingredients
        IngredientCommand ingredientCommand1 = new IngredientCommand();
        IngredientCommand ingredientCommand2 = new IngredientCommand();

        final Long INGREDIENT1_ID = 1L;
        final Long INGREDIENT2_ID = 2L;
        ingredientCommand1.setId(INGREDIENT1_ID);
        ingredientCommand2.setId(INGREDIENT2_ID);

        Set<IngredientCommand> ingredientCommandSet = new HashSet(0);
        ingredientCommandSet.add(ingredientCommand1);
        ingredientCommandSet.add(ingredientCommand2);

        recipeCommand.setIngredients(ingredientCommandSet);

        // Add Notes
        NotesCommand notesCommand = new NotesCommand();

        final Long Notes_ID = 1L;
        notesCommand.setId(Notes_ID);

        recipeCommand.setNotes(notesCommand);

        //Add Categories

        CategoryCommand categoryCommand1 = new CategoryCommand();
        CategoryCommand categoryCommand2 = new CategoryCommand();

        final Long Category_ID1=1L;
        final Long Category_ID2=2L;
        categoryCommand1.setId(Category_ID1);
        categoryCommand2.setId(Category_ID2);

        Set<CategoryCommand> categoryCommands = new HashSet(0);
        categoryCommands.add(categoryCommand1);
        categoryCommands.add(categoryCommand2);

        recipeCommand.setCategories(categoryCommands);



        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);

        assertNotNull(recipe);
        assertEquals(ID,recipe.getId());
        assertEquals(PREP_TIME,recipe.getPrepTime());
        assertEquals(COOK_TIME,recipe.getCookTime());
        assertEquals(DESCRIPTION,recipe.getDescription());
        assertEquals(DIRECTIONS,recipe.getDirections());
        assertEquals(SOURCE,recipe.getSource());
        assertEquals(URL,recipe.getUrl());
        assertEquals(SERVINGS,recipe.getServings());

        assertEquals(2,recipe.getCategories().size());
        assertEquals(2,recipe.getIngredients().size());







    }
}