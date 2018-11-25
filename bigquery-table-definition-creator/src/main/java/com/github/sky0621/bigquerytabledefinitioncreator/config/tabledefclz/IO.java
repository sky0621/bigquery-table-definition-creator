package com.github.sky0621.bigquerytabledefinitioncreator.config.tabledefclz;

import lombok.Data;

/**
 * FIXME: JavaDoc
 */
@Data
public class IO {

    // Excel格納ディレクトリ
    private String inputParameter;

    // VMテンプレート格納ディレクトリ
    private String inputTemplate;

    // VM出力ディレクトリ
    private String outputDir;

}
