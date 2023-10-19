package com.example;

import tests.reiseTest;


public class App {
    public static void main(String[] args) {
        reiseTest.testReiseResultat();
        
        /* 
        // Your main method code here
        WebDriver driver = driverFactory.open("incognito");
        driver.get("https://www.finn.no/");
        String ExcelPath = "C:\\Users\\isvendsen\\projects\\FinnTraining\\travelResults.xlsx";



        // Saving results in Excel
        String sheetName = "results";
        int rowNumber = 5;
        int columnNumber = 5;
        driver.findElement(By.xpath("//button[@data-testid='toggleLowfare']")).click();
        String data = driver.findElement(By.xpath("//td[@data-row='"+rowNumber+"'][@data-col='"+columnNumber+"']")).getText();
        Excel.writeData(ExcelPath, sheetName, rowNumber, columnNumber, data);*/
    }
}
