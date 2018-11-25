package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element;

import org.apache.poi.ss.usermodel.Cell;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;

/**
 * FIXME: JavaDoc
 */
public class TemplateFileComment implements IfVelocityTemplateElement {

    private Cell cell;

    public TemplateFileComment(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        if (cell != null) {
            velocityTemplate.setTemplateFileComment(cell.getStringCellValue());
        }
    }

}
