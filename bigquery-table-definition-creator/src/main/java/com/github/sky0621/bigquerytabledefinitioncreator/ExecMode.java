package com.github.sky0621.bigquerytabledefinitioncreator;

/**
 * FIXME: JavaDoc
 */
public enum ExecMode {
    // BigQueryテーブル定義クラス生成指示
    GEN_TABLE_DEF_CLASS(1, "com.github.sky0621.bigquerytabledefinitioncreator.gen.tabledefclz.GenTableDefClzExecutor"),
    // MEMO: 拡張用
    ;

    private int execArgumentValue;

    private String executorClassName;

    ExecMode(int execArgumentValue, String executorClassName) {
        this.execArgumentValue = execArgumentValue;
        this.executorClassName = executorClassName;
    }

    public int getExecArgumentValue() {
        return execArgumentValue;
    }

    public String getExecutorClassName() {
        return executorClassName;
    }

    public static ExecMode getByArgumentValue(int execArgumentValue) {
        switch (execArgumentValue) {
            case 1:
                return GEN_TABLE_DEF_CLASS;
            default:
                return null;
        }
    }

}
