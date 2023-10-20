package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.elementsReiseResultatPage;
import utilities.Excel;

public class reiseResultatPage {
    private elementsReiseResultatPage elements;
    private WebDriver driver;

    public reiseResultatPage(WebDriver driver){
        this.driver = driver;
        this.elements = new elementsReiseResultatPage(driver);
    }

    public void ventPåProgressBar(){
        // Wait until progress bar disappears (aria-valuenow reaches 100 or element disappears)
        WebDriverWait wait3 = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        By progressBarSelector = elements.progressBarElement();
        wait3.until(ExpectedConditions.or(ExpectedConditions.attributeToBe(progressBarSelector, "aria-valuenow", "100")
        ,ExpectedConditions.invisibilityOfElementLocated(progressBarSelector)));
    }

    public void trykkDirekte(){
        elements.direkteElement().click();
    }

     public void trykkLavpriskalender(){
        elements.lavpriskalenderElement().click();
    }
    
    public void hentPriser(String ExcelPath, String sheetName){
        String data;
        for (int rowNumber=0; rowNumber<8; rowNumber++){
            for (int columnNumber = 0; columnNumber<8; columnNumber++){
                if ((columnNumber == 7) && (rowNumber == 0)){
                    System.out.println("Blank field");
                } else {
                    data = elements.prisElement(rowNumber, columnNumber).getText();
                    Excel.writeData(ExcelPath, sheetName, rowNumber, columnNumber, data);
                    // System.out.println("Value in row " + rowNumber + " and column: " + columnNumber);
                }
            }
        }
        
    }

    public void endreAvreiseStart(){
        String desiredTravelTimeStart = "08:00";
        WebElement sliderTravelTimeStart = elements.sliderAvreiseStart();
        String currentTimeStart = sliderTravelTimeStart.getAttribute("aria-valuetext").split(" ")[1];
        sliderTravelTimeStart.click();
        //Assert.assertEquals(desiredTravelTimeStart, currentTimeStart);
        while (!desiredTravelTimeStart.equals(currentTimeStart)){
            sliderTravelTimeStart.sendKeys(Keys.ARROW_RIGHT);
            currentTimeStart = sliderTravelTimeStart.getAttribute("aria-valuetext").split(" ")[1];
        }
    }

    public void endreAvreiseSlutt(){
        String desiredTravelTimeSlutt = "12:00";
        WebElement sliderTravelTimeSlutt = elements.sliderAvreiseSlutt();
        String currentTimeSlutt = sliderTravelTimeSlutt.getAttribute("aria-valuetext").split(" ")[1];
        sliderTravelTimeSlutt.click();
        while (!desiredTravelTimeSlutt.equals(currentTimeSlutt)){
            sliderTravelTimeSlutt.sendKeys(Keys.ARROW_LEFT);
            currentTimeSlutt = sliderTravelTimeSlutt.getAttribute("aria-valuetext").split(" ")[1];
        }
    }

    public void endreReisetid(){
        int desiredTravelTime = 8;
        WebElement sliderTravelTime = elements.sliderReisetid();
        String maxTravelTime = sliderTravelTime.getAttribute("aria-valuetext");
        int TravelTime = Integer.parseInt(maxTravelTime.split(" ")[0]);
        for (int i = 0; i < (TravelTime-desiredTravelTime) ; i++ ){
            sliderTravelTime.sendKeys(Keys.ARROW_LEFT);
        }
        // Check that we get the desired value
        String aria_valuetext = sliderTravelTime.getAttribute("aria-valuetext");
        Assert.assertEquals(desiredTravelTime, Integer.parseInt(aria_valuetext.split(" ")[0]));
    }
}
