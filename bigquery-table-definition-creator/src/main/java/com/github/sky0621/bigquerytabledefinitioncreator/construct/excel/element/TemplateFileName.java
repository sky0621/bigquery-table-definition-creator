package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element;

import org.apache.poi.ss.usermodel.Cell;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;

/**
 * FIXME: JavaDoc
 */
public class TemplateFileName implements IfVelocityTemplateElement {

    private Cell cell;

    public TemplateFileName(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        // TODO チェック処理など

        velocityTemplate.setTemplateFileName(cell.getStringCellValue());
    }

}
