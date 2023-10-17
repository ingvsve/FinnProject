package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    public static void writeData(String ExcelPath, String sheetName, int rowNumber, int columnNumber, String data){
        // Saving one value in Excel file
        //public void writeData(String ExcelPath, String sheetName, int rowNumber, int columnNumber, String data){}
        try{
            // String ExcelPath = "C:\\Users\\isvendsen\\projects\\FinnTraining\\travelResults.xlsx";
            // String sheetName = "results";

            //File file = new File(ExcelPath);
            FileInputStream file = new FileInputStream(new File(ExcelPath));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNumber);
            XSSFCell cell = row.getCell(columnNumber, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

            if(cell == null){
                cell = row.createCell(columnNumber);
                cell.setCellValue(data);

            }else{
                cell.setCellValue(data);
            }
            // FileOutputStream fio = new FileOutputStream(file, false);
            FileOutputStream outFile = new FileOutputStream(new File(ExcelPath));

            wb.write(outFile);
            wb.close();

        }catch(IOException io) {
            io.printStackTrace();
        }
    }

}
