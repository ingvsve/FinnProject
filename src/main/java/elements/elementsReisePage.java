package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementsReisePage {
    WebDriver driver;
    // private static WebElement element = null;

    public elementsReisePage(WebDriver driver){
        this.driver = driver;
    }

    public static WebElement flyFraElement(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement flyFraElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"origin-roundtrip\"]")));
        return flyFraElement;

        //return driver.findElement(By.xpath("//*[@id=\"origin-roundtrip\"]"));
    }

    public static WebElement flyTilElement(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement flyTilElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"destination-roundtrip\"]")));
        return flyTilElement;
        //return driver.findElement(By.xpath("//*[@id=\"destination-roundtrip\"]"));
    }
    
    public static WebElement utreiseDatoElement(WebDriver driver){
        return driver.findElement(By.xpath("//input[@placeholder='Dato'][@data-testid='date-roundtrip-outbound']"));
    }

    public static WebElement nesteMånedElement(WebDriver driver){
        return driver.findElement(By.xpath("//button[@class='button button--pill button--small absolute right-10 top-4']"));
    }

    public static WebElement torsdag9NovemberElement(WebDriver driver){
        return driver.findElement(By.xpath("//td[@aria-label='torsdag 9. november 2023']"));
    }

    public static WebElement tirsdag14NovemberElement(WebDriver driver){
        return driver.findElement(By.xpath("//td[@aria-label='tirsdag 14. november 2023']"));
    }

    public static WebElement ankrysningHotelElement(WebDriver driver){
        return driver.findElement(By.xpath("//label[@for='openHotelSearch']"));
    }

    public static WebElement søkeKnappElement(WebDriver driver){
        return driver.findElement(By.xpath("//button[@data-testid='flightSearchButton']"));
    }
}
