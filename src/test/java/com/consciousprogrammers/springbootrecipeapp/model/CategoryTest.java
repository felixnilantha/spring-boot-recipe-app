package com.consciousprogrammers.springbootrecipeapp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;


    @Before
    public void setup(){
        category= new Category();
    }

    @Test
    public void getId() {
        Long id= 2L;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}