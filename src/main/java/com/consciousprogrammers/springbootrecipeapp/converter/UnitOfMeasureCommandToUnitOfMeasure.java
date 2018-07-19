package com.consciousprogrammers.springbootrecipeapp.converter;

import com.consciousprogrammers.springbootrecipeapp.command.UnitOfMeasureCommand;
import com.consciousprogrammers.springbootrecipeapp.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMessureCommand) {

        if (unitOfMessureCommand == null) {
            return null;
        }

        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(unitOfMessureCommand.getId());
        unitOfMeasure.setUnitOfMeasure(unitOfMessureCommand.getUnitOfMeasure());

        return unitOfMeasure;
    }
}
