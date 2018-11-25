package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.ClassComment;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.ClassName;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.CellParser;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.IfRowParser;
import org.apache.poi.ss.usermodel.Row;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenTableDefClz;

/**
 * FIXME: JavaDoc
 */
public class TableDefRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplateParameter velocityTemplateParameter) {

        if (configGenTableDefClz().getTable().getTableDefLineIndex() != row.getRowNum()) {
            return true;
        }

        CellParser cellParser = new CellParser(velocityTemplateParameter);
        cellParser.parse(new ClassName(row.getCell(configGenTableDefClz().getTable().getClassNameColIndex())));
        cellParser.parse(new ClassComment(row.getCell(configGenTableDefClz().getTable().getClassCommentColIndex())));

        return true;
    }

}
