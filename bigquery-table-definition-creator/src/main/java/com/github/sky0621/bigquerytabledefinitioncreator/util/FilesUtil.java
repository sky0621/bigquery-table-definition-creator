package com.github.sky0621.bigquerytabledefinitioncreator.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * FIXME: JavaDoc
 */
public class FilesUtil {

    public static boolean outputInit(String vmFileNameFullPath) {
        try {
            if (Files.exists(Paths.get(vmFileNameFullPath))) {
                Files.deleteIfExists(Paths.get(vmFileNameFullPath));
            }
            Files.createFile(Paths.get(vmFileNameFullPath));
        } catch (IOException e) {
            // TODO error handling.
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean output(String vmFileNameFullPath, String str) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(vmFileNameFullPath), StandardOpenOption.APPEND)) {
            writer.write(str);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            // TODO error handling.
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
