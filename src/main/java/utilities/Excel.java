package utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runners.model.TestClass;
import org.openqa.selenium.Dimension;


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
            if (row == null) {
                // Row doesn't exist, create a new row
                row = sheet.createRow(rowNumber);
            }
            XSSFCell cell = row.getCell(columnNumber, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            //cell.setCellValue(data);
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

    public static void leggeInnBilde(String ExcelPath, String sheetName, int rowNumber, int columnNumber, String bildeLink){
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
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }
            XSSFCell cell = row.getCell(columnNumber, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            URL url = new URL(bildeLink);
            InputStream inStream = new BufferedInputStream(url.openStream());
            CreationHelper helper = wb.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();

            anchor.setCol1(columnNumber);
            anchor.setRow1(rowNumber);

            byte[] bytes = IOUtils.toByteArray(inStream);
            Picture picture = drawing.createPicture(anchor, wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG));
            // Scaling the picture to double of the original size
            picture.resize(1, 1);
            row.setHeightInPoints(40);
            FileOutputStream fileout = new FileOutputStream(new File(ExcelPath));
            wb.write(fileout);
            wb.close();



        }catch(IOException io) {
            io.printStackTrace();
        }
    }

    public static ArrayList<String> lageListeFinnkoder(String ExcelPath, String sheetName){
        try{
            FileInputStream file = new FileInputStream(new File(ExcelPath));
            ArrayList<String> listeMedFinnkoder = new ArrayList<String>();
            
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rowNumber = 1;
            XSSFRow row = sheet.getRow(rowNumber);
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }
            XSSFCell cell = row.getCell(0, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            
            while (cell != null) {
                row = sheet.getRow(rowNumber);
                cell = row.getCell(0, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell!=null){
                    listeMedFinnkoder.add(cell.getStringCellValue());
                    rowNumber ++;
                }
            }
            return listeMedFinnkoder;
        } catch (IOException io){
            io.printStackTrace();
            ArrayList<String> listeMedFinnkoder = new ArrayList<String>();
            return listeMedFinnkoder;
        }
    }
    
    public static boolean erFinnkodenDer(String ExcelPath, String sheetName, String finnkode, ArrayList<String> listeMedFinnkoder){
        if (listeMedFinnkoder.contains(finnkode)){
                return true;
        } else { return false;}
    }
}
