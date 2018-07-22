package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.NotesCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Notes;
import com.consciousprogrammers.springbootrecipeapp.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteToNoteCommandTest {


    private NoteToNoteCommand noteToNoteCommand;

    @Before
    public void setUp() throws Exception {
        noteToNoteCommand = new NoteToNoteCommand();
    }

    @Test
    public void convert() {


        final Long ID =1L;
        final String RECIPE_NOTES ="Recipe notes";
        final Long RECIPE_ID = 1L;


        Notes note = new Notes();
        note.setId(ID);
        note.setRecipeNotes(RECIPE_NOTES);

        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);

        note.setRecipe(recipe);


        //Convert

        NotesCommand notesCommand = noteToNoteCommand.convert(note);

        assertNotNull(notesCommand);
        assertEquals(ID,notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());




    }
}