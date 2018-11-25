package com.github.sky0621.bigquerytabledefinitioncreator.config;

import org.yaml.snakeyaml.Yaml;
import com.github.sky0621.bigquerytabledefinitioncreator.error.VelocityTemplateGenException;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * FIXME: JavaDoc
 */
public class ConfigManager {

    private static ConfigGenVm configGenVm;

    public static void init() throws VelocityTemplateGenException {
        String basePath = System.getProperty("user.dir") + "/sky0621/bigquery-table-definition-creator/bigquery-table-definition-creator/";
        System.out.println(basePath);
        if (configGenVm == null) {
            try {
                configGenVm = new Yaml().loadAs(new FileReader(basePath + "config_genvm.yaml"), ConfigGenVm.class);
            } catch (FileNotFoundException e) {
                // TODO Logger使用
                throw new VelocityTemplateGenException(e);
            }
        }
    }

    public static ConfigGenVm configGenVm() {
        return configGenVm;
    }

}
