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

    public WebElement flyFraElement(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        WebElement flyFraElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"origin-roundtrip\"]")));
        return flyFraElement;

        //return driver.findElement(By.xpath("//*[@id=\"origin-roundtrip\"]"));
    }

    public  WebElement flyTilElement(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        WebElement flyTilElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"destination-roundtrip\"]")));
        return flyTilElement;
        //return driver.findElement(By.xpath("//*[@id=\"destination-roundtrip\"]"));
    }
    
    public  WebElement utreiseDatoElement(){
        return this.driver.findElement(By.xpath("//input[@placeholder='Dato'][@data-testid='date-roundtrip-outbound']"));
    }

    public WebElement nesteMånedElement(){
        return this.driver.findElement(By.xpath("//button[@class='button button--pill button--small absolute right-10 top-4']"));
    }

    public WebElement torsdag9NovemberElement(){
        return this.driver.findElement(By.xpath("//td[@aria-label='torsdag 9. november 2023']"));
    }

    public WebElement tirsdag14NovemberElement(){
        return this.driver.findElement(By.xpath("//td[@aria-label='tirsdag 14. november 2023']"));
    }

    public WebElement ankrysningHotelElement(){
        return this.driver.findElement(By.xpath("//label[@for='openHotelSearch']"));
    }

    public WebElement søkeKnappElement(){
        return this.driver.findElement(By.xpath("//button[@data-testid='flightSearchButton']"));
    }
}
