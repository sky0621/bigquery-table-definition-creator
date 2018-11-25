package com.github.sky0621.bigquerytabledefinitioncreator.util;

import java.util.List;

/**
 * FIXME: JavaDoc
 */
public class VarUtil {

    public static String list2String(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String convertResult : list) {
            sb.append(convertResult).append(System.getProperty("line.separator"));
        }
        sb.delete(sb.lastIndexOf(System.getProperty("line.separator")), sb.length());
        return sb.toString();
    }

}
