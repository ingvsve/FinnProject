package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementsReiseResultatPage {
    WebDriver driver;
    // private static WebElement element = null;

    public elementsReiseResultatPage(WebDriver driver){
        this.driver = driver;
    }

    public static By progressBarElement(WebDriver driver){
        return By.xpath("//div[@role='progressbar']");

    }    

    public static WebElement direkteElement(WebDriver driver){
        return driver.findElement(By.xpath("//label[@for='stopoverFilter0']"));
    }

    public static WebElement lavpriskalenderElement(WebDriver driver){
        return driver.findElement(By.xpath("//button[@data-testid='toggleLowfare']"));
    }

    public static WebElement prisElement(WebDriver driver, int rowNumber, int columnNumber){
        return driver.findElement(By.xpath("//td[@data-row='"+rowNumber+"'][@data-col='"+columnNumber+"']"));
    }

    public static WebElement sliderAvreiseStart(WebDriver driver){
        return driver.findElement(By.xpath("//div[@aria-label='Utreise tidligst'][@role='slider']"));
    }

    public static WebElement sliderAvreiseSlutt(WebDriver driver){
        return driver.findElement(By.xpath("//div[@aria-label='Utreise senest'][@role='slider']"));
    }

    public static WebElement sliderReisetid(WebDriver driver){
        return driver.findElement(By.xpath("//div[@aria-label='Maks reisetid'][@role='slider']"));
    }
}
