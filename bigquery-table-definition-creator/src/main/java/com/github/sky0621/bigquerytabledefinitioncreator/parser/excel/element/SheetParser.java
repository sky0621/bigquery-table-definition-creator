package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.ColumnDef;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Optional;

/**
 * FIXME: JavaDoc
 */
public class SheetParser {

    public Optional<VelocityTemplateParameter> parse(Sheet sheet) {

        // Oops...
        ColumnDef.setDisplaySpecificationParseOn(false);

        VelocityTemplateParameter velocityTemplateParameter = new VelocityTemplateParameter();
        velocityTemplateParameter.setPackageName(ConfigManager.configGenTableDefClz().getPackageName());
        velocityTemplateParameter.setSuperClassName(ConfigManager.configGenTableDefClz().getSuperClassName());

        for (Row row : sheet) {
            if (new RowParser().parse(row, velocityTemplateParameter)) {
                continue;
            }
        }
        return Optional.ofNullable(velocityTemplateParameter);
    }

}
