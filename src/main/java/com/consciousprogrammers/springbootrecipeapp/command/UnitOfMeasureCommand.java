package com.consciousprogrammers.springbootrecipeapp.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {

    private Long Id;

    private String unitOfMeasure;


}
