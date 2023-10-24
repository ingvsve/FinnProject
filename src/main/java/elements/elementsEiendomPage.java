package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementsEiendomPage {
    WebDriver driver;
        public elementsEiendomPage(WebDriver driver){
            this.driver = driver;
    }

    public WebElement totalprisFraElement(){
        return this.driver.findElement(By.xpath("//input[@aria-label='Totalpris, minimum']"));
    }

    public WebElement totalprisTilElement(){
        return this.driver.findElement(By.xpath("//input[@aria-label='Totalpris, maksimum']"));
    }

    public WebElement toSoveromSjekkboksElement(){
        return this.driver.findElement(By.xpath("//label[@for='min_bedrooms_2']"));
    }

    public WebElement balkongTerrasseElement(){
        return this.driver.findElement(By.xpath("//label[@for='facilities-1']"));
    }

    public WebElement ikkeFørsteEtasjeSjekkboksElement (){
        return this.driver.findElement(By.xpath("//label[@for='floor_navigator-NOTFIRST']"));
    }

    public WebElement byttTilUtsnittElement(){
        return this.driver.findElement(By.xpath("//button[@title='Bytt til utsnittsmodus']"));
    }
    
    public WebElement kartSøkTekstfeltElement(){
        return this.driver.findElement(By.id("map-search-input"));
    }

    public WebElement eiriksGateElement(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("lo2y7b7vtqg")));
            //By.xpath("//input[@value='Eiriks gate, Oslo']")));
        //return this.driver.findElement(By.xpath("//input[@value='Eiriks gate, Oslo']"));
    }

    public WebElement radiusSliderElement (){
        return this.driver.findElement(By.xpath("//div[@aria-labelledby='radius-slider-label']"));
    }

    public WebElement nyttUtsnittElement(){
        return this.driver.findElement(By.xpath("//button[@class='button button--has-icon max-w-none MapPolygon_button___vMpU']"));
    }
}
