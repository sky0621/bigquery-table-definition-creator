package com.github.sky0621.bigquerytabledefinitioncreator.gen.vm;

import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;
import com.github.sky0621.bigquerytabledefinitioncreator.error.VelocityTemplateGenException;
import com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.filewalkvisitor.ExcelFileParseVisitor;
import com.github.sky0621.bigquerytabledefinitioncreator.parser.excel.MailDefinitionExcelParser;
import com.github.sky0621.bigquerytabledefinitioncreator.IfGenExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * FIXME: JavaDoc
 */
public class GenVmExecutor implements IfGenExecutor {

    public void run() throws VelocityTemplateGenException {
        try {
            ExcelFileParseVisitor visitor = new ExcelFileParseVisitor(new MailDefinitionExcelParser());
            Files.walkFileTree(Paths.get(ConfigManager.configGenVm().getInputDir()), visitor);
        } catch (IOException e) {
            throw new VelocityTemplateGenException(e);
        }
    }

}
