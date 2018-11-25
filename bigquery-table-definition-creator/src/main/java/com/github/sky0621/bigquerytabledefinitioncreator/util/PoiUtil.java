package com.github.sky0621.bigquerytabledefinitioncreator.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

/**
 * FIXME: JavaDoc
 */
public class PoiUtil {

    public static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }

    public static int getRowNum(Cell noCell) {
        Object cellValue = getCellValue(noCell);
        if (cellValue instanceof Double) {
            return ((Double) cellValue).intValue();
        }
        return 0;
    }

    public static int[] getRowNums(Cell noCell, String splitter) {
        return split(getCellValue(noCell), splitter);
    }

    public static boolean splitCheck(Object cellValue, String splitter) {
        if (split(cellValue, splitter) == null) {
            return false;
        }
        return true;
    }

    public static int[] split(Object cellValue, String splitter) {
        if (cellValue == null) return null;
        if (!(cellValue instanceof String)) return null;
        int[] retNums = null;
        if (((String) cellValue).contains(splitter)) {
            String[] nums = ((String) cellValue).split(splitter);
            retNums = new int[nums.length];
            try {
                for (int i = 0; i < nums.length; i++) {
                    retNums[i] = Integer.parseInt(nums[i]);
                }
            } catch (NumberFormatException e) {
                // バッドノウハウ・・・
                // TODO Logger使用
                return null;
            }
        }
        return retNums;
    }

}
