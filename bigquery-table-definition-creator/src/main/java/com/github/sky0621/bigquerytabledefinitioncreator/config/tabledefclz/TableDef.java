package com.github.sky0621.bigquerytabledefinitioncreator.config.tabledefclz;

import lombok.Data;

/**
 * FIXME: JavaDoc
 */
@Data
public class TableDef {

    // テーブル定義（＝クラスコメント・クラス名）のある行
    private int tableDefLineIndex;

    // クラスコメントのある列
    private int classCommentColIndex;

    // クラス名のある列
    private int classNameColIndex;

}
