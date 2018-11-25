package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element;

import org.apache.poi.ss.usermodel.Cell;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;

/**
 * FIXME: JavaDoc
 */
public class ClassName implements IfVelocityTemplateElement {

    private Cell cell;

    public ClassName(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplateParameter velocityTemplateParameter) {

        // TODO チェック処理など

        velocityTemplateParameter.setClassName(cell.getStringCellValue());
    }

}
