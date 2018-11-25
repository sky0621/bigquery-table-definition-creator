package com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.converter;

import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;
import com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.expression.VarExpression;
import com.google.common.base.CaseFormat;

/**
 * FIXME: JavaDoc
 */
public class IncludeConverter {

    public static String createIncludeString(String convertStr, String templateFileType, String templateSetString) {

        String includeFileNameBase = convertStr.replace(ConfigManager.configGenVm().getIncludeConvertStr(), "");
        String beanNameBase = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, includeFileNameBase);
        beanNameBase = beanNameBase.substring(0, 1).toLowerCase() + beanNameBase.substring(1);

        String setStr = "#set($parts = $" + VarExpression.getVarPrefix(templateFileType) + beanNameBase + "Bean)";
        if (templateSetString != null && !templateSetString.equals("")) {
            setStr = "#set($parts = $" + includeFileNameBase + ")";
        }
        String parseStr = "#parse(\"" + ConfigManager.configGenVm().getIncludeVMpath() + includeFileNameBase + ConfigManager.configGenVm().getOutputFileSuffix() + "\")";

        return setStr + System.getProperty("line.separator") + parseStr;
    }

}
