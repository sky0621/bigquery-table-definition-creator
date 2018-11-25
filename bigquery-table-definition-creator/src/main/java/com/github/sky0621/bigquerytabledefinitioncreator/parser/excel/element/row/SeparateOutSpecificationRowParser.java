package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.SeparateOutSpecification;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.CellParser;
import org.apache.poi.ss.usermodel.Row;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.IfRowParser;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenVm;

/**
 * FIXME: JavaDoc
 */
public class SeparateOutSpecificationRowParser implements IfRowParser {

    @Override
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_sampleMail() > row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new SeparateOutSpecification(
                row.getCell(configGenVm().getColIdx_separateOutSpecification_no()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_explain()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_condition()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_systemConvertStrTarget()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_systemExpression()),
                row.getCell(configGenVm().getColIdx_separateOutSpecification_convertMethod())
        ));

        return true;
    }

}
