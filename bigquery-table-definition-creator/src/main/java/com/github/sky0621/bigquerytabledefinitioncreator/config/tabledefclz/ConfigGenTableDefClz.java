package com.github.sky0621.bigquerytabledefinitioncreator.config.tabledefclz;

import lombok.Data;

/**
 * FIXME: JavaDoc
 */
@Data
public class ConfigGenTableDefClz {

    // 入出力関連
    private IO io;

    // 生成クラスのパッケージ
    private String packageName;

    // 生成クラスのスーパークラス
    // TODO: ひとまず親クラスあり前提
    private String superClassName;

    // テーブル自体の定義関連
    private TableDef table;

    // カラムの定義関連
    private ColumnDef column;

    public ConfigGenTableDefClz() {
        this.io = new IO();
        this.table = new TableDef();
        this.column = new ColumnDef();
    }

}
