package com.github.sky0621.bigquerytabledefinitioncreator.config;

import com.github.sky0621.bigquerytabledefinitioncreator.config.tabledefclz.ConfigGenTableDefClz;
import com.github.sky0621.bigquerytabledefinitioncreator.error.VelocityTemplateGenException;
import com.github.sky0621.bigquerytabledefinitioncreator.util.PathUtil;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * FIXME: JavaDoc
 */
public class ConfigManager {

    private static ConfigGenTableDefClz configGenTableDefClz;

    public static void init() throws VelocityTemplateGenException {
        String basePath = PathUtil.getFullPath("/sky0621/bigquery-table-definition-creator/bigquery-table-definition-creator/");
        System.out.println(basePath);
        if (configGenTableDefClz == null) {
            try {
                configGenTableDefClz = new Yaml().loadAs(new FileReader(basePath + "config_gen_tabledefclz.yaml"), ConfigGenTableDefClz.class);
            } catch (FileNotFoundException e) {
                // TODO Logger使用
                throw new VelocityTemplateGenException(e);
            }
        }
    }

    public static ConfigGenTableDefClz configGenTableDefClz() {
        return configGenTableDefClz;
    }

}
