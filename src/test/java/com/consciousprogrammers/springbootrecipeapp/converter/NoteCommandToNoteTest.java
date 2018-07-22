package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.NotesCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteCommandToNoteTest {



    private NoteCommandToNote noteCommandToNote;

    @Before
    public void setUp() throws Exception {

        noteCommandToNote = new NoteCommandToNote();

    }

    @Test
    public void convert() {


        final Long ID = 1L;
        final String DESCRIPTION ="notes description";


        NotesCommand notesCommand = new NotesCommand();

        notesCommand.setId(ID);
        notesCommand.setRecipeNotes(DESCRIPTION);


        Notes notes = noteCommandToNote.convert(notesCommand);

        assertNotNull(notes);
        assertEquals(ID, notes.getId());
        assertEquals(DESCRIPTION, notes.getRecipeNotes());

    }
}