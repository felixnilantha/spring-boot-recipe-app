package com.consciousprogrammers.springbootrecipeapp.repositories;

import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMessure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitOfMessureRepository extends JpaRepository<UnitOfMessure, Long> {


    Optional<UnitOfMessure> findByUnitOfMessure(String unitOfMessure);
}
