package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import org.apache.poi.ss.usermodel.Row;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row.DisplaySpecificationRowParser;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row.SampleMailRowParser;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row.SeparateOutSpecificationRowParser;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.row.TitleRowParser;

/**
 * FIXME: JavaDoc
 */
public class RowParser implements IfRowParser {

    // 副作用。。。
    public boolean parse(Row row, VelocityTemplate velocityTemplate) {

        // VMファイル名の保持
        if (!new TitleRowParser().parse(row, velocityTemplate)) {
            return false;
        }

        // サンプルメールの保持
        if (!new SampleMailRowParser().parse(row, velocityTemplate)) {
            return false;
        }

        // 表示仕様の保持
        if (!new DisplaySpecificationRowParser().parse(row, velocityTemplate)) {
            return false;
        }

        // 出し分け制御仕様
        if (!new SeparateOutSpecificationRowParser().parse(row, velocityTemplate)) {
            return false;
        }

        return true;
    }

}
