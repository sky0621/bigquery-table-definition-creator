package com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.element;

import com.github.sky0621.bigquerytabledefinitioncreator.construct.excel.VelocityTemplate;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import com.github.sky0621.bigquerytabledefinitioncreator.util.PoiUtil;

import static com.github.sky0621.bigquerytabledefinitioncreator.config.ConfigManager.configGenVm;
import static com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.expression.NoExpression.EACH_VALUE_SEPS;
import static com.github.sky0621.bigquerytabledefinitioncreator.gen.vm.expression.NoExpression.RANGE_VALUE_SEPS;

/**
 * FIXME: JavaDoc
 */
@Data
public class DisplaySpecification implements IfVelocityTemplateElement {

    private static boolean displaySpecificationParseOn = false;

    private Cell noCell;

    private Cell explainCell;

    private Cell targetStrCell;

    private Cell convertStrCell;

    private Cell convertTypeCell;

    private int[] nos;

    private int no;

    private String explain;

    private String targetStr;

    private String convertStr;

    private String convertType;

    public DisplaySpecification(Cell noCell, Cell explainCell, Cell targetStrCell, Cell convertStrCell, Cell convertTypeCell) {
        this.noCell = noCell;
        this.explainCell = explainCell;
        this.targetStrCell = targetStrCell;
        this.convertStrCell = convertStrCell;
        this.convertTypeCell = convertTypeCell;
    }

    @Override
    public void doProcess(VelocityTemplate velocityTemplate) {

        if (checkErrorTargetNoCell(noCell)) {
            // TODO Logger使用
            return;
        }

        if (displaySpecificationParseOn) {
            velocityTemplate.getDisplaySpecificationList().add(this);
            expand();
        }
    }

    private boolean checkErrorTargetNoCell(Cell noCell) {
        if (noCell == null) {
            return true;
        }
        try {
            Object cellValue = PoiUtil.getCellValue(noCell);
            if (cellValue instanceof String) {
                if (configGenVm().getMarkingString_displaySpecification().equals((String) cellValue)) {
                    displaySpecificationParseOn = true;
                }
                if (configGenVm().getMarkingString_separateOutSpecification().equals((String) cellValue)) {
                    displaySpecificationParseOn = false;
                }
                if (!PoiUtil.splitCheck(cellValue, EACH_VALUE_SEPS)) {
                    return false;
                }
                if (!PoiUtil.splitCheck(cellValue, RANGE_VALUE_SEPS)) {
                    return false;
                }
                return true;
            }
            if (cellValue instanceof Double) {
                Double dVal = (Double) cellValue;
                dVal.intValue();
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void setDisplaySpecificationParseOn(boolean displaySpecificationParseOn) {
        DisplaySpecification.displaySpecificationParseOn = displaySpecificationParseOn;
    }

    private void expand() {
        if (noCell != null) {
            setNo(PoiUtil.getRowNum(noCell));
            if (getNo() == 0) {
                setNos(PoiUtil.getRowNums(noCell, EACH_VALUE_SEPS));
                if (getNos() == null) {
                    setNos(PoiUtil.getRowNums(noCell, RANGE_VALUE_SEPS));
                }
            }
        }
        if (explainCell != null) {
            setExplain(explainCell.getStringCellValue());
        }
        if (targetStrCell != null) {
            setTargetStr(targetStrCell.getStringCellValue());
        }
        if (convertStrCell != null) {
            setConvertStr(convertStrCell.getStringCellValue());
        }
        if (convertTypeCell != null) {
            setConvertType(convertTypeCell.getStringCellValue());
        }
    }

}
