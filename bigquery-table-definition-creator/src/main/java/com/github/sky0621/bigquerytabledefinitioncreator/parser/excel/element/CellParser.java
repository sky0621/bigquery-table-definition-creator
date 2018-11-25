package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.IfVelocityTemplateElement;

/**
 * FIXME: JavaDoc
 */
public class CellParser {

    // 副作用。。。
    private VelocityTemplate velocityTemplate;

    public CellParser(VelocityTemplate velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }

    public boolean parse(IfVelocityTemplateElement element) {

        // TODO 例外スロー？

        element.doProcess(velocityTemplate);
        return true;
    }

}
