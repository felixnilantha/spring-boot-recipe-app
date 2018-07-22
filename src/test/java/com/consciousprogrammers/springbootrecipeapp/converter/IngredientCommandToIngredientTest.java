package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.command.UnitOfMeasureCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    private IngredientCommandToIngredient ingredientCommandToIngredient;


    @Before
    public void setUp() throws Exception {
        ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void convert() {


        final Long ID = 1L;
        final String DESCRIPTION = "description";
        final BigDecimal AMOUNT = BigDecimal.valueOf(1);
        final Long UOM_ID = 1L;

        IngredientCommand ingredientCommand = new IngredientCommand();

        ingredientCommand.setId(ID);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        ingredientCommand.setUom(unitOfMeasureCommand);


        //convert

        Ingredient ingredient = ingredientCommandToIngredient.convert(ingredientCommand);

        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(UOM_ID, ingredient.getUom().getId());


    }
}