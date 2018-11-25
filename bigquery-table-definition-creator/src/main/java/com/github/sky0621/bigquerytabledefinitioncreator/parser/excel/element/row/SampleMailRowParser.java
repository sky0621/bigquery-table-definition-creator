package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.SampleMail;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.CellParser;
import org.apache.poi.ss.usermodel.Row;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.IfRowParser;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenVm;

/**
 * FIXME: JavaDoc
 */
public class SampleMailRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_sampleMail() > row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new SampleMail(row.getCell(configGenVm().getColIdx_sampleMail_no()), row.getCell(configGenVm().getColIdx_sampleMail_example())));

        return true;
    }

}
