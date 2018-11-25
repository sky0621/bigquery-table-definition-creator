package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import org.apache.poi.ss.usermodel.Row;

/**
 * FIXME: JavaDoc
 */
public interface IfRowParser {

    boolean parse(Row row, VelocityTemplate velocityTemplate);
}
