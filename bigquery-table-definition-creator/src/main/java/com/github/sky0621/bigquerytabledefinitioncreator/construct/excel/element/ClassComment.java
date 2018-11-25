package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import org.apache.poi.ss.usermodel.Cell;

/**
 * FIXME: JavaDoc
 */
public class ClassComment implements IfVelocityTemplateElement {

    private Cell cell;

    public ClassComment(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void doProcess(VelocityTemplateParameter velocityTemplateParameter) {

        // TODO チェック処理など

        velocityTemplateParameter.setClassComment(cell.getStringCellValue());
    }

}
