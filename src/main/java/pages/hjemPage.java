package pages;

import org.openqa.selenium.WebDriver;
import elements.elementsHjemPage;

public class hjemPage {
    private elementsHjemPage elements;
    private WebDriver driver;

    public hjemPage(WebDriver driver){
        this.driver = driver;
        elements = new elementsHjemPage(driver);
    }
    
    public void godtaCookies(WebDriver driver){
        driver.switchTo().frame(1);
        elements.cookieWebElement().click();
        driver.switchTo().defaultContent();
    }

    public void trykkLoggInn (){
        elements.headerWebElement().click();
    }

    public void trykkReise (){
        elements.reiseElement().click();   
    }

    //public static void trykkEiendom (WebDriver driver){
    //    elementsHjemPage.eiendomElement(driver).click();   
    //}    
}
