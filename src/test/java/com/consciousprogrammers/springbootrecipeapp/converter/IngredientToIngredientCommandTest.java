package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Ingredient;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {


    private IngredientToIngredientCommand ingredientToIngredientCommand;


    @Before
    public void setUp() throws Exception {
        ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void convert() {

        final Long ID = 1L;
        final String DESCRIPTION = "description";
        final BigDecimal AMOUNT = BigDecimal.valueOf(1);
        final Long UOM_ID = 1L;
        final Long RECIPE_ID = 1L;

        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        ingredient.setUom(unitOfMeasure);

        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        ingredient.setRecipe(recipe);

        //convert

        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(ingredient);

        assertNotNull(ingredientCommand);
        assertNotNull(ingredientCommand.getUom());
        assertEquals(ID, ingredientCommand.getId());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(UOM_ID, ingredientCommand.getUom().getId());



    }
}