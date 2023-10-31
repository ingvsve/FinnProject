package elements;

import java.time.Duration;
import java.util.List;

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
        return this.driver.findElement(By.xpath("//button[@class='button button--link u-float-right']"));
    }
    
    public WebElement kartSøkTekstfeltElement(){
        return this.driver.findElement(By.id("map-search-input"));
    }

    public WebElement eiriksGateElement(){
        //WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        //return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='map-search-input'][@value='Eiriks gate, Oslo']")));
            //By.xpath("//input[@value='Eiriks gate, Oslo']")));
        return this.driver.findElement(By.xpath("//input[@id='map-search-input'][@value='Eiriks gate, Oslo']"));
    }

    public WebElement radiusSliderElement (){
        return this.driver.findElement(By.xpath("//div[@aria-labelledby='radius-slider-label']"));
    }

    public WebElement nyttUtsnittElement(){
        return this.driver.findElement(By.xpath("//button[@class='button button--has-icon max-w-none MapPolygon_button___vMpU']"));
    }

    public WebElement kartElement(){
        return this.driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']"));
    }

    public List<WebElement> sokeresultaterElement(){
        return this.driver.findElements(By.xpath("//a[@class='sf-search-ad-link link link--dark hover:no-underline']"));
        //return  this.driver.findElements(By.xpath("//article[@class='relative isolate sf-search-ad cursor-pointer overflow-hidden relative transition-all outline-none f-card rounded-8 ']"));
    }

    public WebElement solgtElement(){
        return this.driver.findElement(By.xpath("//span[@class='absolute top-0 left-0 z-10 pointer-events-none py-4 px-8 border rounded-4 inline-flex last-child:mb-0 rounded-bl-0 rounded-tr-0 text-12 border-yellow-100 bg-yellow-100 text-yellow-800']"));
    }
}
