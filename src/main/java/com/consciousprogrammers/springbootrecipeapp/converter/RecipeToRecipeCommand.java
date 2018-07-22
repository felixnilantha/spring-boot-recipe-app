package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.CategoryCommand;
import com.consciousprogrammers.springbootrecipeapp.command.IngredientCommand;
import com.consciousprogrammers.springbootrecipeapp.command.RecipeCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Category;
import com.consciousprogrammers.springbootrecipeapp.model.Ingredient;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {


    @NonNull
    private final CategoryToCategoryCommand categoryConverter;
    @NonNull
    private final IngredientToIngredientCommand ingredientConverter;
    @NonNull
    private final NoteToNoteCommand noteConverter;


    @Override
    public RecipeCommand convert(Recipe recipe) {

        if (recipe == null) {
            return null;
        }


        final RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId(recipe.getId());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setDificulty(recipe.getDificulty());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());
        recipeCommand.setNotes(noteConverter.convert(recipe.getNotes()));


        Set<Category> categories = recipe.getCategories();


        if ((categories != null) && (categories.size() > 0)) {

            for (Category category : categories
                    ) {
                recipeCommand.getCategories().add(categoryConverter.convert(category));
            }
        }


        Set<Ingredient> ingredients = recipe.getIngredients();

        if ((ingredients != null) && (ingredients.size() > 0)) {
            for (Ingredient ingredient : ingredients
                    ) {
                recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient));
            }
        }


        return recipeCommand;
    }
}
