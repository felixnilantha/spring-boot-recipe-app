package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Ingredient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @NonNull
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;


    @Override
    public IngredientCommand convert(Ingredient ingredient) {

        if (ingredient == null) {
            return null;
        }

        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUom(unitOfMeasureConverter.convert(ingredient.getUom()));

        return ingredientCommand;
    }
}
