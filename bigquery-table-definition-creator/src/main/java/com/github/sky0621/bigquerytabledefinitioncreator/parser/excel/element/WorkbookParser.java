package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * FIXME: JavaDoc
 */
public class WorkbookParser {

    public List<Optional<VelocityTemplateParameter>> parse(Workbook workbook) {

        List<Optional<VelocityTemplateParameter>> velocityTemplateList = new ArrayList<>();
        for (Sheet sheet : workbook) {
            velocityTemplateList.add(new SheetParser().parse(sheet));
        }
        return velocityTemplateList;
    }

}
