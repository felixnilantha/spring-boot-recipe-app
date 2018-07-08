package com.consciousprogrammers.springbootrecipeapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMessure {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String unitOfMessure;


    public Long getId() {
        return Id;
    }


    public String getUnitOfMessure() {
        return unitOfMessure;
    }

    public void setUnitOfMessure(String unitOfMessure) {
        this.unitOfMessure = unitOfMessure;
    }
}
