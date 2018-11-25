package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.TemplateFileComment;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.TemplateFileName;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.TemplateFileType;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.TemplateSetString;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.CellParser;
import org.apache.poi.ss.usermodel.Row;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.IfRowParser;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenVm;

/**
 * FIXME: JavaDoc
 */
public class TitleRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        if (configGenVm().getLineIdx_templateFileName() != row.getRowNum()) {
            return true;
        }

        // TODO 例外スロー？

        CellParser cellParser = new CellParser(velocityTemplate);
        cellParser.parse(new TemplateFileName(row.getCell(configGenVm().getColIdx_templateFileName())));
        cellParser.parse(new TemplateFileType(row.getCell(configGenVm().getColIdx_templateFileType())));
        cellParser.parse(new TemplateFileComment(row.getCell(configGenVm().getColIdx_templateFileComment())));
        cellParser.parse(new TemplateSetString(row.getCell(configGenVm().getColIdx_templateSetString())));

        return true;
    }

}
