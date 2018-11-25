package com.github.sky0621.bigquerytabledefinitioncreator;

import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;

/**
 * FIXME: JavaDoc
 */
public class Main {

    // [機能]
    // 1.Excel解析⇒VMファイル生成
    // 2.VMファイル⇒Beanクラス生成
    // 3.VM+Bean by Velocity⇒メール文例出力

    public static void main(String... args) {
        try {
            Argument argument = new Argument(args);
            ConfigManager.init();
            new Executor().run(ExecMode.getByArgumentValue(argument.getExecMode()));
            System.exit(0);
        } catch (Throwable t) {
            // TODO Logger使用
            t.printStackTrace();
            System.exit(-1);
        }
    }

}
