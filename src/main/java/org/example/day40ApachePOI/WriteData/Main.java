package org.example.day40ApachePOI.WriteData;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Open File in Write Mode
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile.xlsx"
        );
// 2. Create Workbook and Sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
// 3. Create a Row (Index 0)
        XSSFRow row1 = sheet.createRow(0);
// 4. Create Cells and Set Data
        row1.createCell(0).setCellValue("Java");
        row1.createCell(1).setCellValue(19); // Can pass integers directly
        row1.createCell(2).setCellValue("Automation");
// 5. Attach Workbook to File and Save
        workbook.write(file);
        workbook.close();
        file.close();
    }
}

