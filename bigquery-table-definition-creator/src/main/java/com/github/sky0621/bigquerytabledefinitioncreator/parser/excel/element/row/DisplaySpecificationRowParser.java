package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.DisplaySpecification;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.CellParser;
import org.apache.poi.ss.usermodel.Row;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.IfRowParser;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenVm;

/**
 * FIXME: JavaDoc
 */
public class DisplaySpecificationRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_sampleMail() > row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new DisplaySpecification(
                row.getCell(configGenVm().getColIdx_displaySpecification_no()),
                row.getCell(configGenVm().getColIdx_displaySpecification_explain()),
                row.getCell(configGenVm().getColIdx_displaySpecification_targetStr()),
                row.getCell(configGenVm().getColIdx_displaySpecification_convertStr()),
                row.getCell(configGenVm().getColIdx_displaySpecification_convertType())
        ));

        return true;
    }

}
