package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.DisplaySpecification;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.SeparateOutSpecification;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Optional;

/**
 * FIXME: JavaDoc
 */
public class SheetParser {

    public Optional<VelocityTemplate> parse(Sheet sheet) {

        // Oops...
        DisplaySpecification.setDisplaySpecificationParseOn(false);
        SeparateOutSpecification.setSeparateOutSpecificationParseOn(false);

        VelocityTemplate velocityTemplate = new VelocityTemplate();
        for (Row row : sheet) {
            if (new RowParser().parse(row, velocityTemplate)) {
                continue;
            }
        }
        return Optional.ofNullable(velocityTemplate);
    }

}
