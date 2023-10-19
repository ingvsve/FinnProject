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
    public static void ventPåProgressBar(WebDriver driver){
        // Wait until progress bar disappears (aria-valuenow reaches 100 or element disappears)
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        By progressBarSelector = elementsReiseResultatPage.progressBarElement(driver);
        wait3.until(ExpectedConditions.or(ExpectedConditions.attributeToBe(progressBarSelector, "aria-valuenow", "100")
        ,ExpectedConditions.invisibilityOfElementLocated(progressBarSelector)));
    }

    public static void trykkDirekte(WebDriver driver){
        elementsReiseResultatPage.direkteElement(driver).click();
    }

     public static void trykkLavpriskalender(WebDriver driver){
        elementsReiseResultatPage.lavpriskalenderElement(driver).click();
    }
    
    public static void hentPriser(WebDriver driver, String ExcelPath, String sheetName){
        String data;
        for (int rowNumber=0; rowNumber<8; rowNumber++){
            for (int columnNumber = 0; columnNumber<9; columnNumber++){
                if ((columnNumber != 8) && (rowNumber != 0)){
                    data = elementsReiseResultatPage.prisElement(driver, rowNumber, columnNumber).getText();
                    Excel.writeData(ExcelPath, sheetName, rowNumber, columnNumber, data);
                }
            }
        }
        
    }

    public static void endreAvreiseStart(WebDriver driver){
        String desiredTravelTimeStart = "08:00";
        WebElement sliderTravelTimeStart = elementsReiseResultatPage.sliderAvreiseStart(driver);
        String currentTimeStart = sliderTravelTimeStart.getAttribute("aria-valuetext").split(" ")[1];
        sliderTravelTimeStart.click();
        //Assert.assertEquals(desiredTravelTimeStart, currentTimeStart);
        while (!desiredTravelTimeStart.equals(currentTimeStart)){
            sliderTravelTimeStart.sendKeys(Keys.ARROW_RIGHT);
            currentTimeStart = sliderTravelTimeStart.getAttribute("aria-valuetext").split(" ")[1];
        }
    }

    public static void endreAvreiseSlutt(WebDriver driver){
        String desiredTravelTimeSlutt = "12:00";
        WebElement sliderTravelTimeSlutt = elementsReiseResultatPage.sliderAvreiseSlutt(driver);
        String currentTimeSlutt = sliderTravelTimeSlutt.getAttribute("aria-valuetext").split(" ")[1];
        sliderTravelTimeSlutt.click();
        while (!desiredTravelTimeSlutt.equals(currentTimeSlutt)){
            sliderTravelTimeSlutt.sendKeys(Keys.ARROW_LEFT);
            currentTimeSlutt = sliderTravelTimeSlutt.getAttribute("aria-valuetext").split(" ")[1];
        }
    }

    public static void endreReisetid(WebDriver driver){
        int desiredTravelTime = 8;
        WebElement sliderTravelTime = elementsReiseResultatPage.sliderReisetid(driver);
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
