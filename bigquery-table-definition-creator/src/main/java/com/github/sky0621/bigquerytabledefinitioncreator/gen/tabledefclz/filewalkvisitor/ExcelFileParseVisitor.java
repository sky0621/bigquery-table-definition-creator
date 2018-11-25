package com.github.sky0621.bigquerytabledefinitioncreator.gen.tabledefclz.filewalkvisitor;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.TableDefinitionExcelParser;
import com.github.sky0621.bigquerytabledefinitioncreator.util.FilesUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * FIXME: JavaDoc
 */
public class ExcelFileParseVisitor implements FileVisitor<Path> {

    private TableDefinitionExcelParser parser;
    private Template tableDefClzTemplate;

    public ExcelFileParseVisitor(TableDefinitionExcelParser parser, Template tableDefClzTemplate) {
        this.parser = parser;
        this.tableDefClzTemplate = tableDefClzTemplate;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        try {
            Optional<List<Optional<VelocityTemplateParameter>>> velocityTemplateListOptional = parser.parse(file);
            List<Optional<VelocityTemplateParameter>> velocityTemplateList = velocityTemplateListOptional.orElse(new ArrayList<>());

            velocityTemplateList.stream().forEach(
                    velocityTemplateOptional -> {
                        // Oops...
                        VelocityTemplateParameter velocityTemplateParameter = velocityTemplateOptional.get();
                        if (velocityTemplateParameter == null) {
                            // TODO Nothing to do ?
                        } else {
                            VelocityContext context = new VelocityContext();
                            context.put("param", velocityTemplateParameter);
                            StringWriter sw = new StringWriter();
                            this.tableDefClzTemplate.merge(context, sw);
                            String mergeResult = sw.toString();
                            sw.flush();

                            // 出力
                            FilesUtil.outputInit(velocityTemplateParameter.getClassName());
                            FilesUtil.output(velocityTemplateParameter.getClassName(), mergeResult);
                        }
                    }
            );
        } catch (Exception e) {
            throw new IOException(e);
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        // TODO error handling.
        System.out.println("[FAILED]" + exc.toString());
        return FileVisitResult.TERMINATE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}
