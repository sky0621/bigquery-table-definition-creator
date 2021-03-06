package com.github.sky0621.bigquerytabledefinitioncreator.ui;

import com.github.sky0621.bigquerytabledefinitioncreator.config.tabledefclz.ConfigGenTableDefClz;
import com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.github.sky0621.bigquerytabledefinitioncreator.Executor;

import static com.github.sky0621.bigquerytabledefinitioncreator.ExecMode.GEN_TABLE_DEF_CLASS;

/**
 * FIXME: JavaDoc
 */
public class JavaFXMain extends Application {

    TextField inputDirTField;
    TextField outputDirTField;
    Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("メール送信用テンプレートファイル自動生成ツール");

        Label explain = new Label();
        explain.setText("指定のフォーマットで書かれたExcelファイルが置かれたディレクトリと生成物の出力先を指定してください。初期状態では sample ディレクトリ配下を指定しています。");

        ConfigManager.init();
        ConfigGenTableDefClz configGenTableDefClz = ConfigManager.configGenTableDefClz();

        Label inputDirExplain = new Label();
        inputDirExplain.setText("Excelファイル格納ルートディレクトリをフルパスで入力：");

        inputDirTField = new TextField();
        inputDirTField.setText(configGenTableDefClz.getIo().getInputParameter());

        Label outputDirExplain = new Label();
        outputDirExplain.setText("出力ファイル格納ディレクトリをフルパスで入力：");

        outputDirTField = new TextField();
        outputDirTField.setText(configGenTableDefClz.getIo().getOutputDir());

        Button parseBtn = new Button();
        parseBtn.setText("生成");
        parseBtn.setOnAction(actionEvent -> {
            try {
                configGenTableDefClz.getIo().setInputParameter(inputDirTField.getText());
                configGenTableDefClz.getIo().setOutputDir(outputDirTField.getText());
                new Executor().run(GEN_TABLE_DEF_CLASS);
                resultLabel.setText("生成終了！");   // TODO 即レス？
            } catch (Throwable t) {
                t.printStackTrace();
                resultLabel.setText(t.getMessage());
            }
        });

        resultLabel = new Label();

        // Pane
        VBox pane = new VBox(10d);
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().add(inputDirExplain);
        pane.getChildren().add(inputDirTField);
        pane.getChildren().add(outputDirExplain);
        pane.getChildren().add(outputDirTField);
        pane.getChildren().add(parseBtn);
        pane.getChildren().add(resultLabel);

        // Scene
        Scene scene = new Scene(pane);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
