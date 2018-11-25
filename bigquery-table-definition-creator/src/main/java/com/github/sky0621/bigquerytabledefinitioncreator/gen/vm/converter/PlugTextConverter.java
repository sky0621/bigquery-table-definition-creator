package com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.converter;

import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;
import com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.expression.VarExpression;

/**
 * FIXME: JavaDoc
 */
public class PlugTextConverter {

    public static String createPlugTextString(String example, String convertStr, String templateFileType) {

        String plugTextVarBase = convertStr.replace(ConfigManager.configGenVm().getPlubTextStr(), "");
        return example.replace(example, VarExpression.exp(plugTextVarBase, templateFileType));
    }

}
