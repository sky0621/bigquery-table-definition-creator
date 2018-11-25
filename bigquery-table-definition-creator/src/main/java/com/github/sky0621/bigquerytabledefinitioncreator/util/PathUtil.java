package com.github.sky0621.bigquerytabledefinitioncreator.util;

/**
 * FIXME: JavaDoc
 */
public class PathUtil {
    public static String getFullPath(String path) {
        return System.getProperty("user.dir") + path;
    }
}
