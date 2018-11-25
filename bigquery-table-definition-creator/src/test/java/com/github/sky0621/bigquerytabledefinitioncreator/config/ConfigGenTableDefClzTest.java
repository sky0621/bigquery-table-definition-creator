package com.github.sky0621.bigquerytabledefinitioncreator.config;

import com.github.sky0621.bigquerytabledefinitioncreator.config.tabledefclz.ConfigGenTableDefClz;
import com.github.sky0621.bigquerytabledefinitioncreator.util.PathUtil;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * FIXME: JavaDoc
 */
public class ConfigGenTableDefClzTest {
    @Test
    public void testXXXX() {
        String basePath = PathUtil.getFullPath("/");
        System.out.println(basePath);
        ConfigGenTableDefClz configGenTableDefClz = null;
        try {
            configGenTableDefClz = new Yaml().loadAs(new FileReader(basePath + "config_gen_tabledefclz.yaml"), ConfigGenTableDefClz.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(configGenTableDefClz.toString());
    }
}
