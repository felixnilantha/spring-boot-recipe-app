package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.CategoryCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    private CategoryToCategoryCommand categoryToCategoryCommand;

    @Before
    public void setUp() throws Exception {
        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    @Test
    public void convert() {

        final Long ID = 1L;
        final String DESCRIPTION = "description";

        Category category = new Category();
        category.setId(1L);
        category.setDescription("description");

        CategoryCommand categoryCommand= categoryToCategoryCommand.convert(category);

        assertEquals(ID, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());



    }
}