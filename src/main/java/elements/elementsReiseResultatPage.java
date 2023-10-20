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

    public By progressBarElement(){
        return By.xpath("//div[@role='progressbar']");

    }    

    public WebElement direkteElement(){
        return this.driver.findElement(By.xpath("//label[@for='stopoverFilter0']"));
    }

    public WebElement lavpriskalenderElement(){
        return this.driver.findElement(By.xpath("//button[@data-testid='toggleLowfare']"));
    }

    public  WebElement prisElement(int rowNumber, int columnNumber){
        return this.driver.findElement(By.xpath("//td[@data-row='"+rowNumber+"'][@data-col='"+columnNumber+"']"));
    }

    public WebElement sliderAvreiseStart(){
        return this.driver.findElement(By.xpath("//div[@aria-label='Utreise tidligst'][@role='slider']"));
    }

    public WebElement sliderAvreiseSlutt(){
        return driver.findElement(By.xpath("//div[@aria-label='Utreise senest'][@role='slider']"));
    }

    public WebElement sliderReisetid(){
        return this.driver.findElement(By.xpath("//div[@aria-label='Maks reisetid'][@role='slider']"));
    }
}
