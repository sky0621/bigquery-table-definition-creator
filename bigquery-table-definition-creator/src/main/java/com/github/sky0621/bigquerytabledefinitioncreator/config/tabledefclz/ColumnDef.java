package com.github.sky0621.bigquerytabledefinitioncreator.config.tabledefclz;

import lombok.Data;

/**
 * FIXME: JavaDoc
 */
@Data
public class ColumnDef {

    // カラムの解析をはじめる行
    private int parseStartLineIndex;

    // BigQueryテーブル上のカラム名のある列
    private int bigqueryColumnNameColIndex;

    // BigQueryテーブル上のカラムタイプのある列
    private int bigqueryColumnTypeColIndex;

    // BigQueryテーブル上のカラムモードのある列
    private int bigqueryColumnModeColIndex;

    // BigQueryテーブル上のカラム日本語名のある列
    private int bigqueryJapaneseNameColIndex;

    // BigQueryテーブル上のカラム日本語コメントのある列
    private int bigqueryJapaneseCommentColIndex;

}
