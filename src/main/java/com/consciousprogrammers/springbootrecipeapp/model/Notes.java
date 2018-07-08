package com.consciousprogrammers.springbootrecipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * No cascade, delete recipe will delete notes
     */
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;



}
