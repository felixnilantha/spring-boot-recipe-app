package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.UnitOfMeasureCommand;
import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {


    private  UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Before
    public void setUp() throws Exception {
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void convert() {

        final Long ID=1L;
        final String UOM = "uom";

        UnitOfMeasure unitOfMeasure= new UnitOfMeasure();
        unitOfMeasure.setId(ID);
        unitOfMeasure.setUnitOfMeasure(UOM);

        UnitOfMeasureCommand unitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure);

        assertNotNull(unitOfMeasureCommand);
        assertEquals(ID,unitOfMeasureCommand.getId());
        assertEquals(UOM,unitOfMeasureCommand.getUnitOfMeasure());
    }
}