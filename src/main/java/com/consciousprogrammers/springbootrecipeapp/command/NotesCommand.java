package com.consciousprogrammers.springbootrecipeapp.command;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;
    private String recipeNotes;



}
