package com.consciousprogrammers.springbootrecipeapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    // private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private byte[] image;


    @Enumerated(value = EnumType.STRING)
    private Dificulty dificulty;

    /**
     * Delete Recipe, Delete Notes
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;


    @ManyToMany
    @JoinTable(name = "recipe_categories", joinColumns = @JoinColumn(name ="recipe_id"), inverseJoinColumns = @JoinColumn(name ="category_id"))
    private Set<Category> categories = new HashSet<>();


    public Recipe() {
    }

    public Recipe(String description, Integer prepTime, Integer cookTime, Integer servings, String source, String url, String directions, byte[] image, Notes notes) {
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.source = source;
        this.url = url;
        this.directions = directions;
        this.image = image;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient){

        ingredient.setRecipe(this);

        this.ingredients.add(ingredient);

        return this;

    }

    public Set<Ingredient> getçs() {
        return ingredients;
    }

    public void setIngredient(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Dificulty getDificulty() {
        return dificulty;
    }

    public void setDificulty(Dificulty dificulty) {
        this.dificulty = dificulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }



}
