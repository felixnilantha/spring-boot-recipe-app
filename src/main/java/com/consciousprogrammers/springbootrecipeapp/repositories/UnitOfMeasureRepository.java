package com.consciousprogrammers.springbootrecipeapp.repositories;

import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, Long> {


    Optional<UnitOfMeasure> findByUnitOfMessure(String unitOfMeasure);
}
