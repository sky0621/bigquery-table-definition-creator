package com.github.sky0621.bigquerytabledefinitioncreator.gen.tabledefclz;

import com.github.sky0621.bigquerytabledefinitioncreator.IfGenExecutor;
import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;
import com.github.sky0621.bigquerytabledefinitioncreator.error.VelocityTemplateGenException;
import com.github.sky0621.bigquerytabledefinitioncreator.gen.tabledefclz.filewalkvisitor.ExcelFileParseVisitor;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.TableDefinitionExcelParser;
import com.github.sky0621.bigquerytabledefinitioncreator.util.PathUtil;
import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * FIXME: JavaDoc
 */
public class GenTableDefClzExecutor implements IfGenExecutor {

    public void run() throws VelocityTemplateGenException {
        try {
            Velocity.init();
            String templatePath = ConfigManager.configGenTableDefClz().getIo().getInputTemplate();
            String templatePath2 = Paths.get(templatePath).toString();
            String templatePath3 = PathUtil.getFullPath(templatePath);
            Template template = Velocity.getTemplate(templatePath3);
//            Template template = Velocity.getTemplate(PathUtil.getFullPath(ConfigManager.configGenTableDefClz().getIo().getInputTemplate()));

            ExcelFileParseVisitor visitor = new ExcelFileParseVisitor(new TableDefinitionExcelParser(), template);

            Files.walkFileTree(Paths.get(ConfigManager.configGenTableDefClz().getIo().getInputParameter()), visitor);

        } catch (IOException e) {
            throw new VelocityTemplateGenException(e);
        }
    }

}
