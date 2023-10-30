package excelHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelHandLing {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Row row;
    Cell cell;
    File file;
    FileInputStream inputStream;

    @Test
    public void handleExcel() throws IOException {

        file = new File(".//Excel//ApachePOI.xlsx");
        inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheetAt(0);

        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(1).getLastCellNum();

        for (int r = 0; r < totalRows; r++) {

            row = sheet.getRow(r);

            for (int c = 0; c < totalCells; c++) {

                cell = row.getCell(c);

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case BLANK:
                        System.out.print("This cell is blank.");
                        break;
                    default:
                        break;
                }

            }
            System.out.println();

        }
    }
}