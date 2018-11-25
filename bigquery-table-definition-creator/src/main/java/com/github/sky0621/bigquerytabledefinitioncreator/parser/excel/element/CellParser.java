package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.IfVelocityTemplateElement;

/**
 * FIXME: JavaDoc
 */
public class CellParser {

    // 副作用。。。
    private VelocityTemplateParameter velocityTemplateParameter;

    public CellParser(VelocityTemplateParameter velocityTemplateParameter) {
        this.velocityTemplateParameter = velocityTemplateParameter;
    }

    public boolean parse(IfVelocityTemplateElement element) {

        // TODO 例外スロー？

        element.doProcess(velocityTemplateParameter);
        return true;
    }

}
