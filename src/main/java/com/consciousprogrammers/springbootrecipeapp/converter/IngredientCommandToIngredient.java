package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Ingredient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    @NonNull
    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;


    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {

        if (ingredientCommand == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientCommand.getId());
        ingredient.setAmount(ingredientCommand.getAmount());
        ingredient.setDescription(ingredientCommand.getDescription());
        ingredient.setUom(unitOfMeasureConverter.convert(ingredientCommand.getUom()));

        return null;
    }
}
