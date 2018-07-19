package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.NotesCommand;
import com.consciousprogrammers.springbootrecipeapp.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteCommand implements Converter<Notes, NotesCommand> {
    @Override
    public NotesCommand convert(Notes notes) {

        if (notes == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(notes.getId());
        notesCommand.setRecipeNotes(notes.getRecipeNotes());
        return notesCommand;
    }
}
