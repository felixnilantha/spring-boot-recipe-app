package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.CategoryCommand;
import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Category;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {


    @NonNull
    private final CategoryCommandToCategory categoryConverter;
    @NonNull
    private final IngredientCommandToIngredient ingredientConverter;
    @NonNull
    private final NoteCommandToNote noteConverter;


    @Override
    public Recipe convert(RecipeCommand recipeCommand) {

        if (recipeCommand == null) {
            return null;
        }


        final Recipe recipe = new Recipe();

        recipe.setId(recipeCommand.getId());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setDificulty(recipeCommand.getDificulty());
        recipe.setServings(recipeCommand.getServings());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setNotes(noteConverter.convert(recipeCommand.getNotes()));


        Set<CategoryCommand> categoryCommands = recipeCommand.getCategories();


        if ((categoryCommands != null) && (categoryCommands.size() > 0)) {

            for (CategoryCommand categoryCommand : categoryCommands
                    ) {
                recipe.getCategories().add(categoryConverter.convert(categoryCommand));
            }
        }


        Set<IngredientCommand> ingredientCommands = recipeCommand.getIngredients();

        if ((ingredientCommands != null) && (ingredientCommands.size() > 0)) {
            for (IngredientCommand ingredientCommand : ingredientCommands
                    ) {
                recipe.getIngredients().add(ingredientConverter.convert(ingredientCommand));
            }
        }


        return recipe;
    }
}
