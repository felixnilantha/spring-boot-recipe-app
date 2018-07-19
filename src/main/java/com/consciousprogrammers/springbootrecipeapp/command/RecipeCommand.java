package com.consciousprogrammers.springbootrecipeapp.command;

import com.consciousprogrammers.springbootrecipeapp.model.Dificulty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Dificulty dificulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();

}
