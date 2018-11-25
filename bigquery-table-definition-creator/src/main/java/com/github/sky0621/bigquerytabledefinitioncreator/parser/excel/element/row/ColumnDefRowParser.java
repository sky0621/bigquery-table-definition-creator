package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.ColumnDef;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.CellParser;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.IfRowParser;
import org.apache.poi.ss.usermodel.Row;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenTableDefClz;

/**
 * FIXME: JavaDoc
 */
public class ColumnDefRowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplateParameter velocityTemplateParameter) {

        if (configGenTableDefClz().getColumn().getParseStartLineIndex() < row.getRowNum()) {
            return true;
        }

        CellParser cellParser = new CellParser(velocityTemplateParameter);
        ColumnDef colDef = new ColumnDef();
        colDef.setFieldNameCell(row.getCell(configGenTableDefClz().getColumn().getBigqueryColumnNameColIndex()));
        colDef.setBigqueryColumnNameCell(row.getCell(configGenTableDefClz().getColumn().getBigqueryColumnNameColIndex()));
        colDef.setBigqueryTypeCell(row.getCell(configGenTableDefClz().getColumn().getBigqueryColumnTypeColIndex()));
        colDef.setBigqueryModeCell(row.getCell(configGenTableDefClz().getColumn().getBigqueryColumnModeColIndex()));
        colDef.setBigqueryJapaneseNameCell(row.getCell(configGenTableDefClz().getColumn().getBigqueryJapaneseNameColIndex()));
        colDef.setBigqueryJapaneseCommentCell(row.getCell(configGenTableDefClz().getColumn().getBigqueryJapaneseCommentColIndex()));

        cellParser.parse(colDef);

        return true;
    }

}
