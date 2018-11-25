package com.github.sky0621.bigquerytabledefinitioncreator.gen.vm;

/**
 * FIXME: JavaDoc
 */
public enum SeparateOutSpecificationConvertMethod {
    TARGET_ONLY("ターゲットのみ"),
    LINE_REPLACE("行丸ごと"),
    ANYLINE_SURROUND("複数行を囲む");

    private String str;

    SeparateOutSpecificationConvertMethod(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public static SeparateOutSpecificationConvertMethod enumOf(String str) {
        for (SeparateOutSpecificationConvertMethod m : values()) {
            if (m.getStr().equals(str)) {
                return m;
            }
        }
        return TARGET_ONLY;
    }

}
