package com.sap.report.tool;

/**
 * @author : Jenson.Liu
 * @date : 2019-07-26  10:59
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class TestImportXlsx {

    public static void main(String[] args) throws Exception  {

        File excelFile = new File("src/main/resources/1_Unique_eCATT.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
        XSSFSheet sheet = wb.getSheet("eCATT");

        for (Row row : sheet) {
            for (Cell cell : row) {

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getRichStringCellValue().getString());
                        System.out.print("|");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.print(String.valueOf(cell.getDateCellValue()));
                        } else {
                            System.out.print(cell.getNumericCellValue());
                        }
                        System.out.print("|");
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("|");
                        break;
                    default:
                }
            }
            System.out.println();
        }

        //读取图片
        List<XSSFPictureData> pictures = wb.getAllPictures();
        for (int i = 0; i < pictures.size(); i++) {
            XSSFPictureData pictureData = pictures.get(i);
            byte[] picData = pictureData.getData();
            System.out.println("image-size:" + picData.length);
        }


        System.out.println(wb.getSheetName(0));
    }
}