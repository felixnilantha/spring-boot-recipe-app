package com.consciousprogrammers.springbootrecipeapp.command;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {

    private Long id;
    private String description;



}
