package com.consciousprogrammers.springbootrecipeapp.repositories;

import com.consciousprogrammers.springbootrecipeapp.model.Category;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

 Optional<Category> findByDescription(String description);

}
