package org.example.day40ApachePOI.ReadData;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Open File in Read Mode (dynamically getting project path)
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                "\\testdata\\myfile.xlsx");
// 2. Open Workbook and Sheet
        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheetAt(0); // Safely gets the very first sheet
        XSSFSheet sheet = workbook.getSheet("sheet1");
// 3. Find total rows and columns
        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(0).getLastCellNum();
// 4. Nested Loop to read Data
        for (int r = 0; r <= totalRows; r++) {
            XSSFRow currentRow = sheet.getRow(r);
            for (int c = 0; c < totalCells; c++) {
                XSSFCell cell = currentRow.getCell(c);
                // toString() converts dates, numbers, and strings all into Java Strings
                System.out.print(cell.toString() + " ");
            }
            System.out.println();
        }
// 5. Close files to free up memory!
        workbook.close();
        file.close();
    }
}
