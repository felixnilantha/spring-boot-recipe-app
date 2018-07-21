package com.consciousprogrammers.springbootrecipeapp.repositories;

import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUnitOfMeasure() {

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUnitOfMeasure("cup");

        assertEquals("cup",unitOfMeasureOptional.get().getUnitOfMeasure());
    }
}