package com.github.sky0621.bigquerytabledefinitioncreator.config;

import lombok.Data;

/**
 * FIXME: JavaDoc
 */
@Data
public class ConfigGenVm {

    // Excel格納ディレクトリ
    private String inputDir;

    // VM出力ディレクトリ
    private String outputDir;

    /*
     * 行インデックス
     */
    // VMファイル名がある行
    private int lineIdx_templateFileName;

    // メール文例の解析をはじめる行
    private int lineIdx_sampleMail;

    /*
     * 列インデックス
     */
    // VM物理ファイル名がある列Index
    private int colIdx_templateFileName;    // I列

    // VMが本体か部品であるかがある列Index
    private int colIdx_templateFileType;    // J列

    // Bean生成時のクラスコメント列Index
    private int colIdx_templateFileComment; // K列

    // 冒頭の部品セット文の列Index
    private int colIdx_templateSetString;   // L列

    // No列がある列Index
    private int colIdx_sampleMail_no;

    // メール文例がある列Index
    private int colIdx_sampleMail_example;

    // 「項目番号」がある列Index
    private int colIdx_displaySpecification_no;  // F列

    // 「説明」がある列Index
    private int colIdx_displaySpecification_explain;   // G列

    // 「置換対象」がある列Index
    private int colIdx_displaySpecification_targetStr; // H列

    // 「置換変数」がある列Index
    private int colIdx_displaySpecification_convertStr;    // I列

    // 「型」がある列Index
    private int colIdx_displaySpecification_convertType;   // J列

    private int colIdx_separateOutSpecification_no;

    private int colIdx_separateOutSpecification_explain;

    private int colIdx_separateOutSpecification_condition;

    private int colIdx_separateOutSpecification_systemConvertStrTarget;

    private int colIdx_separateOutSpecification_systemExpression;

    private int colIdx_separateOutSpecification_convertMethod;

    private String outputFileSuffix;

    /*
     * 解析行判定マーキング用
     */
    // 表示仕様の解析をはじめる上でのマーキングを行うための文字列
    private String markingString_displaySpecification;

    // 出し分け仕様の解析をはじめる上でのマーキングを行うための文字列
    private String markingString_separateOutSpecification;

    /*
     * その他
     */
    // インクルードを表す置換変数の一部
    private String includeConvertStr;

    // VMの種別が「本体」の場合の文字列
    private String templateFileTypeMain;

    // VMファイルのインクルード時のパス
    private String includeVMpath;

    // 差し込みファイルを表す置換変数の一部
    private String plubTextStr;

}
