package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.UnitOfMeasureCommand;
import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure == null) {
            return null;
        }

        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(unitOfMeasure.getId());
        unitOfMeasureCommand.setUnitOfMeasure(unitOfMeasure.getUnitOfMeasure());

        return unitOfMeasureCommand;
    }
}
