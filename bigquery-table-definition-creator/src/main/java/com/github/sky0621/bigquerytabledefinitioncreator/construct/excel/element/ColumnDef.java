package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplateParameter;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;

/**
 * FIXME: JavaDoc
 */
@Data
public class ColumnDef implements IfVelocityTemplateElement {

    private static boolean displaySpecificationParseOn = false;

    // フィールド物理名
    private Cell fieldNameCell;

    // BigQuery上のカラム物理名
    private Cell bigqueryColumnNameCell;

    // BigQuery上のタイプ
    private Cell bigqueryTypeCell;

    // BigQuery上のモード
    private Cell bigqueryModeCell;

    // BigQuery上のカラム和名
    private Cell bigqueryJapaneseNameCell;

    // BigQuery上のカラムコメント
    private Cell bigqueryJapaneseCommentCell;

    private String fieldName;

    private String bigqueryColumnName;

    private String bigqueryType;

    private String bigqueryMode;

    private String bigqueryJapaneseName;

    private String bigqueryJapaneseComment;

    public ColumnDef(){
    }

    public ColumnDef(
            Cell fieldNameCell,
            Cell bigqueryColumnNameCell,
            Cell bigqueryTypeCell,
            Cell bigqueryModeCell,
            Cell bigqueryJapaneseNameCell,
            Cell bigqueryJapaneseCommentCell
    ) {
        this.fieldNameCell = fieldNameCell;
        this.bigqueryColumnNameCell = bigqueryColumnNameCell;
        this.bigqueryTypeCell = bigqueryTypeCell;
        this.bigqueryModeCell = bigqueryModeCell;
        this.bigqueryJapaneseNameCell = bigqueryJapaneseNameCell;
        this.bigqueryJapaneseCommentCell = bigqueryJapaneseCommentCell;
    }

    @Override
    public void doProcess(VelocityTemplateParameter velocityTemplateParameter) {
        if (displaySpecificationParseOn) {
            velocityTemplateParameter.getFields().add(this);
            expand();
        }
    }

    public static void setDisplaySpecificationParseOn(boolean displaySpecificationParseOn) {
        ColumnDef.displaySpecificationParseOn = displaySpecificationParseOn;
    }

    private void expand() {
        if (fieldNameCell != null) {
            setFieldName(fieldNameCell.getStringCellValue());
        }
        if (bigqueryColumnNameCell != null) {
            setBigqueryColumnName(bigqueryColumnNameCell.getStringCellValue());
        }
        if (bigqueryTypeCell != null) {
            setBigqueryType(bigqueryTypeCell.getStringCellValue());
        }
        if (bigqueryModeCell != null) {
            setBigqueryMode(bigqueryModeCell.getStringCellValue());
        }
        if (bigqueryJapaneseNameCell != null) {
            setBigqueryJapaneseName(bigqueryJapaneseNameCell.getStringCellValue());
        }
        if (bigqueryJapaneseCommentCell != null) {
            setBigqueryJapaneseComment(bigqueryJapaneseCommentCell.getStringCellValue());
        }
    }

}
