package com.consciousprogrammers.springbootrecipeapp.repositories;

import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
