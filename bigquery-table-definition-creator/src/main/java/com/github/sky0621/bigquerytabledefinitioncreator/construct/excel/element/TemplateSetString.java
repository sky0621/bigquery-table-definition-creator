package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import org.apache.poi.ss.usermodel.Cell;

/**
 * FIXME: JavaDoc
 */
public class TemplateSetString implements IfVelocityTemplateElement {

    private Cell cell;

    public TemplateSetString(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        if (cell != null) {
            velocityTemplate.setTemplateSetString(cell.getStringCellValue());
        }
    }

}
