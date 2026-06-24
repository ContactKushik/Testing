package org.example.poipractice.read;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Read {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("sheet1");

        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(0).getLastCellNum();

        for(int r = 0;r<=totalRows;r++){
            XSSFRow currentRow = sheet.getRow(r);
            for(int c = 0; c<totalCells;c++){
                XSSFCell cell = currentRow.getCell(c);
                System.out.println(cell.toString()+" ");
            }
        }

        workbook.close();
        fis.close();
    }
}
