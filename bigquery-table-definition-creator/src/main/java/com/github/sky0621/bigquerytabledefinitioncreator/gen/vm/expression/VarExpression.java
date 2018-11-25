package com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.expression;

import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;

/**
 * FIXME: JavaDoc
 */
public class VarExpression {

    public static String exp(String convertTo, String templateFileType) {
        return "$!{" + getVarPrefix(templateFileType) + convertTo + "}";
    }

    public static String getVarPrefix(String templateFileType) {
        String setStrPrefix = "parts.";
        if (ConfigManager.configGenVm().getTemplateFileTypeMain().equals(templateFileType)) {
            setStrPrefix = "bean.";
        }
        return setStrPrefix;
    }

}
