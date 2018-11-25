package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.SampleMail;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.DisplaySpecification;
import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element.SeparateOutSpecification;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenVm;

/**
 * FIXME: JavaDoc
 */
@Data
public class VelocityTemplate {

    private String templateFileName;

    private String templateFileType;

    private String templateFileComment;

    private String templateSetString;

    // メール文例
    private List<SampleMail> sampleMailList;

    // 表示仕様
    private List<DisplaySpecification> displaySpecificationList;

    // 出し分け仕様
    private List<SeparateOutSpecification> separateOutSpecificationList;

    public VelocityTemplate() {
        sampleMailList = new ArrayList<>();
        displaySpecificationList = new ArrayList<>();
        separateOutSpecificationList = new ArrayList<>();
    }

    public String getTemplateFileName() {
        String parts = "";
        if (!configGenVm().getTemplateFileTypeMain().equals(templateFileType)) {
            parts = File.separator + "parts";
        }
        return configGenVm().getOutputDir() + parts + File.separator + templateFileName + configGenVm().getOutputFileSuffix();
    }

}
