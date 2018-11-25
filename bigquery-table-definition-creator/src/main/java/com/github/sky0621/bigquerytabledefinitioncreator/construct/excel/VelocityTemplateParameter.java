package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.ColumnDef;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenTableDefClz;

/**
 * FIXME: JavaDoc
 */
@Data
public class VelocityTemplateParameter {

    /*
     * 全シート共通
     */
    private String packageName;

    private String superClassName;

    /*
     * シート毎に異なる
     */
    private String className;

    private String classComment;

    /*
     * １シートのカラム定義関連行群
     */
    private List<ColumnDef> fields;

    public VelocityTemplateParameter() {
        fields = new ArrayList<>();
    }

    public String getClassName() {
        return configGenTableDefClz().getIo().getOutputDir() + File.separator + className + ".java";
    }

}
