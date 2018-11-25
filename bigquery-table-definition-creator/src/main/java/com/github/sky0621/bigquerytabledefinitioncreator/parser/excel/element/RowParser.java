package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row.ColumnDefRowParser;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row.TableDefRowParser;
import org.apache.poi.ss.usermodel.Row;

/**
 * FIXME: JavaDoc
 */
public class RowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplateParameter velocityTemplateParameter) {

        // VMファイル名の保持
        if (!new TableDefRowParser().parse(row, velocityTemplateParameter)) {
            return false;
        }

        // 表示仕様の保持
        if (!new ColumnDefRowParser().parse(row, velocityTemplateParameter)) {
            return false;
        }

        return true;
    }

}
