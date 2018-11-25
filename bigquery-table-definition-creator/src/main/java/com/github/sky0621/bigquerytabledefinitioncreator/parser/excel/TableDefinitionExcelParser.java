package com.github.sky0621.bigquerytabledefinitioncreator.parser.excel;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.element.WorkbookParser;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/**
 * FIXME: JavaDoc
 */
public class TableDefinitionExcelParser {

    public Optional<List<Optional<VelocityTemplateParameter>>> parse(Path excelFilePath) {

        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(excelFilePath.toFile(), null, true);
        } catch (IOException e) {
            // TODO Logger使用
            return null;
        }
        return Optional.ofNullable(new WorkbookParser().parse(workbook));
    }

}
