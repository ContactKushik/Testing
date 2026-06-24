package org.example.poipractice.write;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Write {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile.xlsx"
        );

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet  = workbook.createSheet("sheet1");

        XSSFRow row1 = sheet.createRow(0);

        row1.createCell(0).setCellValue("Kushik");

        row1.createCell(1).setCellValue("works in Microsoft");
        row1.createCell(2).setCellValue("with 1cr pkg");

        workbook.write(file);
        workbook.close();
        file.close();
    }
}
