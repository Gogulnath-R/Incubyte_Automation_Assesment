package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class ExcelWriter {
    public static void main(String[] args) {
        String[] columns = {"Test Case ID", "Scenario", "Steps", "Expected Result", "Actual Result", "Status"};

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Signup Test Cases");

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        Object[][] testCases = {
            {"TC01", "User successfully signs up", "Open page > Enter details > Click Create", "Dashboard displayed", "", ""},
            {"TC02", "User tries existing email", "Open page > Enter existing email > Click Create", "Error message displayed", "", ""},
            {"TC03", "User enters weak password", "Open page > Enter weak password > Click Create", "Password validation error", "", ""}
        };

        int rowNum = 1;
        for (Object[] testCase : testCases) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < testCase.length; i++) {
                row.createCell(i).setCellValue(testCase[i].toString());
            }
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Ensure the "testcases" directory exists
        File directory = new File("testcases");
        if (!directory.exists()) {
            directory.mkdirs();  // Create the directory if it doesn't exist
        }

        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("testcases/Signup_TestCases.xlsx");
            workbook.write(fileOut);
            System.out.println("✅ Excel file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
