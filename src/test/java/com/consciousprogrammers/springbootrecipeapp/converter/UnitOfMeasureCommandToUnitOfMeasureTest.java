package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.UnitOfMeasureCommand;
import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    @Before
    public void setUp() throws Exception {
        unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void convert() {

        final Long ID=1L;
        final String UOM = "uom";

        UnitOfMeasureCommand unitOfMeasureCommand= new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(ID);
        unitOfMeasureCommand.setUnitOfMeasure(UOM);

        UnitOfMeasure unitOfMeasure = unitOfMeasureCommandToUnitOfMeasure.convert(unitOfMeasureCommand);

        assertNotNull(unitOfMeasure);
        assertEquals(ID,unitOfMeasure.getId());
        assertEquals(UOM,unitOfMeasure.getUnitOfMeasure());

    }
}